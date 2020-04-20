/**
 * 
 */
package com.pratik.todolistwithtests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pratikdas
 *
 */
@RestController
public class TodoController {
	
	@GetMapping("/randomtodo")
	public String fetchAnyTodoItem(@RequestParam(name = "dayofweek", defaultValue = "sunday") final String dayOfWeek) {
		return String.format("my random todo of %s is workout", dayOfWeek);
	}

}
