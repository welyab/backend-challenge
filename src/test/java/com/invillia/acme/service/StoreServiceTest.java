package com.invillia.acme.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.invillia.acme.data.repository.StoreRepository;

/**
 * Unit tests for the class <code>StoreService</code>.
 *
 * @author Welyab Paula
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.NONE)
public class StoreServiceTest {

	@MockBean
	@SuppressWarnings("javadoc")
	private StoreRepository storeRepository;

	@Autowired
	@SuppressWarnings("javadoc")
	private StoreService storeService;

	@Test(expected = NullPointerException.class)
	@SuppressWarnings("javadoc")
	public void saveOrUpdateShouldThrowNullPointerExceptionWhenStoreIsNull() throws IdPresentException {
		storeService.save(null);
	}
}
