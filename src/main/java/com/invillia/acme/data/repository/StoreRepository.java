package com.invillia.acme.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.invillia.acme.data.model.Store;

/**
 * Spring based repository class for <code>Store</code> entity.
 *
 * @author Welyab Paula
 */
@Repository
public interface StoreRepository extends PagingAndSortingRepository<Store, Long> {

	/**
	 * Finds the stores that matches with given filters.
	 * 
	 * @param name The store names.
	 * 
	 * @return The list of stores that match with given filters.
	 */
	public List<Store> findByNameContaining(String name);
}
