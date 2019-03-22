package com.invillia.acme.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.invillia.acme.data.model.Store;
import com.invillia.acme.data.repository.StoreRepository;
import com.invillia.acme.util.UuidUtils;

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

	/**
	 * Saves or updates the information of given store.
	 *
	 * <p>
	 * If the given store has an <code>identification</code>
	 * ({@linkplain Store#getId() store.getId()}), than is required to store to
	 * have a code identification ({@linkplain Store#getCode()
	 * store.getCode()}).
	 *
	 * @param store The store to be saved or updated.
	 *
	 * @return The <i>saved</i> or <i>updated</i> store object. It recommended to
	 *         use the returned object.
	 */
	public Store saveOrUpdate(Store store) {
		Preconditions.checkNotNull(store, "store");
		if (StringUtils.isNotBlank(store.getCode())) {
			Preconditions.checkArgument(UuidUtils.isValid(store.getCode()), "Invalid store's code.");
		} else {
			store.setCode(UuidUtils.random());
		}
		return storeRepository.save(store);
	}

	/**
	 * Retrieves the store associated with given <code>code</code> parameter.
	 *
	 * @param code The store's code.
	 *
	 * @return The existent store entry. May return <code>null</code> if there
	 *         is no store associated with given <code>code</code>.
	 *
	 * @throws NullPointerException If the given code parameter is
	 *             <code>null</code>.
	 */
	public Store findByCode(String code) {
		Preconditions.checkNotNull(code, "code");
		return storeRepository.findById(code).orElse(null);
	}

	/**
	 * Retrieves the stores according they match with given filters.
	 *
	 * @param name The store name. This filters will filter the stores that
	 *            contains given name.
	 *
	 * @return The list of found stores.
	 */
	public List<Store> find(String name) {
		return storeRepository.findByNameContaining(name);
	}
}
