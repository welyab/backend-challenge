package com.invillia.acme.rest.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.data.model.Store;
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

	/**
	 * Retrieves the store located by the given <code>code</code> parameter.
	 * 
	 * @param code The store's code.
	 * 
	 * @return The HTTP response body with information about requested store..
	 */
	@GetMapping(path = "{code}")
	public HttpEntity<Store> getStore(@PathVariable(name = "code") String code) {
		return ResponseEntity.of(Optional.ofNullable(storeService.findByCode(code)));
	}

	/**
	 * Find registered stores by aplying given parametes as filters.
	 * 
	 * @param name
	 * 
	 * @return The HTTP response body with information about requested stores.
	 */
	@GetMapping
	public HttpEntity<List<Store>> findStores(@MatrixVariable(name = "name") String name) {
		return ResponseEntity.ok(storeService.find(name));
	}

	/**
	 * Creates a new <code>Store</code>.
	 * 
	 * @param code The code of the store to be updated.
	 * @param store The store to be saved.
	 * 
	 * @return The response for further Java/HTTP translation.
	 */
	@PutMapping(path = "{code}")
	public HttpEntity<Store> updateStore(
		@PathVariable(name = "code") String code,
		@RequestBody Store store
	) {
		if (!store.getCode().equals(code)) {
			return ResponseEntity.badRequest().build();
		}
		store = storeService.saveOrUpdate(store);
		ControllerLinkBuilder self = linkTo(methodOn(StoreController.class).getStore(store.getCode()));
		store.add(self.withSelfRel());
		return ResponseEntity
			.created(self.toUri())
			.body(store);
	}

	/**
	 * Creates a new <code>Store</code>.
	 * 
	 * @param store The store to be saved.
	 * 
	 * @return The response for further Java/HTTP translation.
	 */
	@PostMapping
	public HttpEntity<Store> saveStore(@RequestBody Store store) {
		if (StringUtils.isNotBlank(store.getCode())) {
			return ResponseEntity.badRequest().build();
		}
		store = storeService.saveOrUpdate(store);
		ControllerLinkBuilder self = linkTo(methodOn(StoreController.class).getStore(store.getCode()));
		store.add(self.withSelfRel());
		return ResponseEntity
			.created(self.toUri())
			.body(store);
	}
}
