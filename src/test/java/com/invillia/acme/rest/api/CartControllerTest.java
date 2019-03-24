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
import com.invillia.acme.data.model.Cart;
import com.invillia.acme.rest.api.dto.CartDto;
import com.invillia.acme.service.CartService;

/**
 * Unit tests for <code>CartController</code>.
 * 
 * @author Welyab Paula
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CartController.class)
public class CartControllerTest {

    @Autowired
    @SuppressWarnings("javadoc")
    private MockMvc mvc;

    @MockBean
    @SuppressWarnings("javadoc")
    private CartService cartService;

    @Test
    @SuppressWarnings("javadoc")
    public void createCartForStoreShouldWorkProperly() throws Exception {
	CartDto cartDto = new CartDto();
	cartDto.setStoreId(321654L);
	String json = new Gson().toJson(cartDto);
	cartDto.setCartId(987654L);
	Cart cart = cartDto.toCart();
	Mockito.when(cartService.save(Mockito.any(Cart.class))).thenReturn(cart);
	mvc.perform(MockMvcRequestBuilders.post("/carts")
		.contentType(MediaType.APPLICATION_JSON)
		.content(json))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andExpect(MockMvcResultMatchers.header().exists("location"));
    }
}
