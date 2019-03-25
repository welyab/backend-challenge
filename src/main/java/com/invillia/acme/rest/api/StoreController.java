package com.invillia.acme.rest.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.data.model.Store;
import com.invillia.acme.rest.api.dto.PagedStoresDto;
import com.invillia.acme.rest.api.dto.StoreDto;
import com.invillia.acme.service.EntryNotFoundException;
import com.invillia.acme.service.IdPresentException;
import com.invillia.acme.service.StoreService;

/**
 * REST services for <code>Store</code> class.
 *
 * @author Welyab Paula
 *
 * @see StoreService
 */
@RestController
@RequestMapping(path = "stores")
public class StoreController {

    @Autowired
    @SuppressWarnings("javadoc")
    private StoreService storeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedStoresDto> getAllPaged(
	    @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageIndex
    ) {
	Page<Store> page = storeService.findAllPaged(pageIndex);
	List<StoreDto> dtos = page.stream()
		.map(StoreDto::new)
		.map(this::fillCommonLinks)
		.collect(Collectors.toList());
	PagedStoresDto listDto = new PagedStoresDto();
	listDto.setStores(dtos);
	listDto.setPageNumber(page.getNumber());
	listDto.setPageSize(page.getSize());
	listDto.setPageTotalItems(page.getNumberOfElements());
	listDto.setTotalItems((int) page.getTotalElements());

	if (page.hasPrevious()) {
	    listDto.add(
		    linkTo(methodOn(StoreController.class).getAllPaged(page.previousPageable().getPageNumber()))
			    .withRel(Link.REL_PREVIOUS)
	    );
	}
	if (page.hasNext()) {
	    listDto.add(
		    linkTo(methodOn(StoreController.class).getAllPaged(page.nextPageable().getPageNumber()))
			    .withRel(Link.REL_NEXT)
	    );
	}
	return ResponseEntity.ok(listDto);
    }

    @GetMapping(
	    path = "{id}",
	    produces = MediaType.APPLICATION_JSON_VALUE,
	    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StoreDto> get(@PathVariable(name = "id") Long id) {
	Store store = storeService.findById(id);
	return ResponseEntity.of(
		Optional.ofNullable(store)
			.map(StoreDto::new)
			.map(this::fillCommonLinks)
	);
    }

    @PostMapping(
	    produces = MediaType.APPLICATION_JSON_VALUE,
	    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StoreDto> save(
	    @RequestBody StoreDto storeDto
    ) {
	Store store = null;
	try {
	    store = storeService.save(storeDto.toStore());
	} catch (IdPresentException e) {
	    return ResponseCast.cast(
		    ResponseEntity
			    .badRequest()
			    .body(String.format(
				    "The provided store cannot have an ID. Found: %d",
				    storeDto.getCode()
			    ))
	    );
	}
	storeDto = new StoreDto(store);

	return ResponseEntity
		.created(getLinkBuilderForSelfRef(storeDto).toUri())
		.body(fillCommonLinks(storeDto));
    }

    @PutMapping(
	    produces = MediaType.APPLICATION_JSON_VALUE,
	    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StoreDto> update(
	    @RequestBody StoreDto storeDto
    ) throws EntryNotFoundException {
	Store store = storeService.update(storeDto.toStore());
	storeDto = new StoreDto(store);

	return ResponseEntity
		.created(getLinkBuilderForSelfRef(storeDto).toUri())
		.body(fillCommonLinks(storeDto));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
	storeService.delete(id);
	return ResponseEntity.noContent().build();
    }

    private ControllerLinkBuilder getLinkBuilderForSelfRef(StoreDto storeDto) {
	return linkTo(methodOn(StoreController.class).get(storeDto.getCode()));
    }

    private StoreDto fillCommonLinks(StoreDto storeDto) {
	storeDto.add(getLinkBuilderForSelfRef(storeDto).withSelfRel());
	storeDto.add(linkTo(methodOn(StoreController.class).delete(storeDto.getCode())).withSelfRel());
	return storeDto;
    }
}
