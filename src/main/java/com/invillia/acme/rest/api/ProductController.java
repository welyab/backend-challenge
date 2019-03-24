package com.invillia.acme.rest.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.data.model.Product;
import com.invillia.acme.rest.api.dto.PagedProductsDto;
import com.invillia.acme.rest.api.dto.ProductDto;
import com.invillia.acme.service.ProductService;

@RestController
@SuppressWarnings("javadoc")
@RequestMapping(path = "products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(
	    path = "{id}",
	    produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<ProductDto> get(@PathVariable(name = "id") Long id) {
	return ResponseEntity.of(
		Optional.ofNullable(productService.findById(id))
			.map(ProductDto::new)
			.map(this::fillCommonLinks)
	);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PagedProductsDto> getAllPaged(
	    @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber
    ) {
	Page<Product> pagedProduts = productService.findAllPaged(pageNumber);
	PagedProductsDto page = new PagedProductsDto();
	page.setPageNumber(pagedProduts.getNumber());
	page.setPageSize(pagedProduts.getSize());
	page.setPageTotalItems(pagedProduts.getNumberOfElements());
	page.setTotalItems((int) pagedProduts.getTotalElements());
	page.setStores(
		pagedProduts.getContent()
			.stream()
			.map(ProductDto::new)
			.map(this::fillCommonLinks)
			.collect(Collectors.toList())
	);
	if (pagedProduts.hasNext()) {
	    page.add(linkTo(
		    methodOn(ProductController.class).getAllPaged(pagedProduts.nextPageable().getPageNumber())
	    ).withRel(Link.REL_NEXT));
	}
	if (pagedProduts.hasPrevious()) {
	    page.add(linkTo(
		    methodOn(ProductController.class).getAllPaged(pagedProduts.previousPageable().getPageNumber())
	    ).withRel(Link.REL_PREVIOUS));
	}
	return ResponseEntity.ok(page);
    }

    private ControllerLinkBuilder getLinkBuilderForSelfRef(ProductDto storeDto) {
	return linkTo(methodOn(ProductController.class).get(storeDto.getIdentifier()));
    }

    private ProductDto fillCommonLinks(ProductDto productDto) {
	productDto.add(getLinkBuilderForSelfRef(productDto).withSelfRel());
	return productDto;
    }

}
