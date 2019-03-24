package com.invillia.acme.rest.api;

import org.junit.Ignore;
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
	private MockMvc mvc;

	@MockBean
	@SuppressWarnings("javadoc")
	private StoreService storeService;

	@Test
	@Ignore
	@SuppressWarnings("javadoc")
	public void saveStoreShoulWorkProperly() throws Exception {
		Store store = new Store();
		store.setName("Store Good");
		String json = new Gson().toJson(store);
		store.setId(10L);
		Mockito.when(storeService.save(Mockito.any(Store.class)))
			.thenReturn(store);
		mvc.perform(MockMvcRequestBuilders.post("/stores")
			.contentType(MediaType.APPLICATION_JSON).content(json))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.header().exists("location"))
			.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	@Ignore
	@SuppressWarnings("javadoc")
	public void saveStoreShoulReturnHttpBadRequestWhenStoreHasCode() throws Exception {
		Store store = new Store();
		store.setName("Store Good");
		store.setId(10L);
		String json = new Gson().toJson(store);
		mvc.perform(MockMvcRequestBuilders.post("/stores")
			.contentType(MediaType.APPLICATION_JSON).content(json))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
