package com.invillia.acme.data.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invillia.acme.data.model.Store;

/**
 * Spring based repository class for <code>Store</code> entity.
 *
 * @author Welyab Paula
 */
@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {
}
