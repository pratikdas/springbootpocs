/**
 * 
 */
package com.pratik.todolistwithtests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



/**
 * @author pratikdas
 *
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest
class TodoControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@Test
	void fetchAnyTodoItem_for_default() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/randomtodo");
		MvcResult mvcResult =  mvc.perform(request).andReturn();
		String responseContent = mvcResult.getResponse().getContentAsString();
		System.out.println(responseContent);
        assertEquals("my random todo of sunday is workout", responseContent);
	}
	
	@Test
	void fetchAnyTodoItem_for_dayofweek() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/randomtodo?dayofweek=monday")).andExpect(content().string("my random todo of monday is workout"));
	}

}
