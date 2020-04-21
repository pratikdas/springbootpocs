/**
 * 
 */
package com.pratik.todolistwithtests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



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
	
	@Test
	void createTodoItem_with_valid_data() throws Exception {
		TodoItem todoItem = new TodoItem();
		todoItem.setId("uyyyu");
		
		mvc.perform(MockMvcRequestBuilders.post("/create")
				    .content(asJson(todoItem))
				    .contentType(MediaType.APPLICATION_JSON)
				    .accept(MediaType.APPLICATION_JSON))
		            .andExpect(MockMvcResultMatchers.status().isCreated())
		            .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
	}
	
	private String asJson(TodoItem todoItem ) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(todoItem);
	}

}
