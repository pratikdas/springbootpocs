/**
 * 
 */
package com.pratik.todolistwithtests;

import org.springframework.stereotype.Service;

/**
 * @author Pratik Das
 *
 */
@Service
public class TodoService {
	
	public TodoItem createTodoItem(final TodoItem todoItem) {
		
		
		TodoItem item =  TodoItem.builder().id("123").name("drink water").status("pending").build();
		return item;
	}
	
	public TodoItem fetchTodoItem(final TodoItem todoItem) {
		TodoItem item = TodoItem.builder().name("drink water").build();
		return item;
	}

}
