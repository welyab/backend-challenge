package com.invillia.acme.rest.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;
import com.invillia.acme.data.model.Store;
import com.invillia.acme.service.StoreService;
import com.invillia.acme.util.UuidUtils;

/**
 * Unit tests for <code>StoreController</code> class.
 * 
 * @author Welyab Paula
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = StoreController.class)
public class StoreControllerTest {

	@Autowired
	@SuppressWarnings("javadoc")
	private MockMvc mock;

	@MockBean
	@SuppressWarnings("javadoc")
	private StoreService storeService;

	@Test
	@SuppressWarnings("javadoc")
	public void saveStoreShoulWorkProperly() throws Exception {
		Store store = new Store();
		store.setName("Store Good");
		String json = new Gson().toJson(store);
		store.setCode(UuidUtils.random());
		Mockito.when(storeService.saveOrUpdate(Mockito.any(Store.class)))
			.thenReturn(store);
		mock.perform(MockMvcRequestBuilders.post("/stores")
			.contentType(MediaType.APPLICATION_JSON).content(json))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.header().exists("location"))
			.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	@SuppressWarnings("javadoc")
	public void saveStoreShoulReturnHttpBadRequestWhenStoreHasCode() throws Exception {
		Store store = new Store();
		store.setName("Store Good");
		store.setCode(UuidUtils.random());
		String json = new Gson().toJson(store);
		mock.perform(MockMvcRequestBuilders.post("/stores")
			.contentType(MediaType.APPLICATION_JSON).content(json))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
