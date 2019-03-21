package com.invillia.acme.service;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.invillia.acme.data.model.Store;
import com.invillia.acme.data.model.repository.StoreRepository;

/**
 * Operations with <code>Store</code> objects.
 *
 * @author Welyab Paula
 */
@Service
public class StoreService {

	@Autowired
	@SuppressWarnings("javadoc")
	private StoreRepository storeRepository;

	public Store saveOrUpdate(Store store) throws DataValidationException {
		Preconditions.checkNotNull(store, "store");
		if (StringUtils.isBlank(store.getCode())) {
			store.setCode(UUID.randomUUID().toString());
		}
		return storeRepository.save(store);
	}
}
