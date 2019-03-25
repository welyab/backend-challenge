package com.invillia.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.invillia.acme.data.model.Store;
import com.invillia.acme.data.repository.StoreRepository;

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
     * Saves the information of given store.
     * 
     * <p>
     * This method was designed to only save the given <code>store</code>
     * parameter. It creates the ID for the store, so, if a store is informed
     * with a already present ID, this method thrown a exception.
     *
     * @param store The store to be saved or updated.
     *
     * @return The <i>saved</i> or <i>updated</i> store object. It recommended
     *         to use the returned object.
     * 
     * @throws NullPointerException In the case of the given <code>store</code>
     *             parameter be <code>null</code>.
     * @throws IdPresentException The the <code>store</code> parameter to save
     *             has the ID field filled.
     */
    public Store save(Store store) throws IdPresentException {
	Preconditions.checkNotNull(store, "store");
	if (store.getId() != null) {
	    throw new IdPresentException(String.format("Id: %d", store.getId()));
	}
	return storeRepository.save(store);
    }

    /**
     * Updates the information of given store.
     * 
     * <p>
     * This method was designed to only update given store. So, if the entry
     * does not exist, a exception is thrown.
     * 
     * @param store The store to be updated.
     * 
     * @return The <code>updated</code> store object. It is recommended to use
     *         the returned object.
     * 
     * @throws NullPointerException If the given <code>store</code> parameter is
     *             <code>null</code>.
     * @throws EntryNotFoundException Indicates that given store entity does not
     *             exist in the repository (may be valid use
     *             {@linkplain #save(Store) save} method).
     */
    public Store update(Store store) throws EntryNotFoundException {
	Preconditions.checkNotNull(store, "store");
	if (!storeRepository.existsById(store.getId())) {
	    throw new EntryNotFoundException(String.format("Store not found: ID = %d", store.getId()));
	}
	return storeRepository.save(store);
    }

    /**
     * Retrieves the store associated with given <code>code</code> parameter.
     * 
     * @param id The store identification.
     *
     * @return The existent store entry. May return <code>null</code> if there
     *         is no store associated with given <code>code</code>.
     *
     * @throws NullPointerException If the given code parameter is
     *             <code>null</code>.
     */
    public Store findById(Long id) {
	Preconditions.checkNotNull(id, "id");
	return storeRepository.findById(id).orElse(null);
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

    /**
     * Erases the store identified by given <code>id</code> parameter from the
     * database.
     * 
     * @param id The store identification.
     */
    public void delete(Long id) {
	storeRepository.deleteById(id);
    }

    public Page<Store> findAllPaged(int pageIndex) {
	PageRequest pageRequest = PageRequest.of(pageIndex, 5, Direction.ASC, "name");
	return storeRepository.findAll(pageRequest);
    }
}
