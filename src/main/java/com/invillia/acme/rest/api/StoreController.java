package com.invillia.acme.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.data.model.Store;
import com.invillia.acme.service.DataValidationException;
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

	@PostMapping
	public void saveStore(@RequestBody Store store) throws DataValidationException {
		storeService.saveOrUpdate(store);
	}
}
