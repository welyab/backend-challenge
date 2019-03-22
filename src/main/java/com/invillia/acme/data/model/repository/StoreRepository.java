package com.invillia.acme.data.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invillia.acme.data.model.Store;

/**
 * Spring based repository class for <code>Store</code> entity.
 *
 * @author Welyab Paula
 */
@Repository
public interface StoreRepository extends CrudRepository<Store, String> {

	/**
	 * Finds the stores that matches with given filters.
	 * 
	 * @param name The store names.
	 * 
	 * @return The list of stores that match with given filters.
	 */
	public List<Store> findByNameContaining(String name);
}
