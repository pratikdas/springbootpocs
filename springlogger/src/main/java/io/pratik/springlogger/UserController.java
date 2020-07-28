/**
 * 
 */
package io.pratik.springlogger;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pratik Das
 *
 */
@RestController
@Slf4j
public class UserController {
	
	@GetMapping("/")
	public List<User> getUsers() {
		log.info("In user controller ");
		
		log.debug("setting list of users");
		
		List<User> users = Arrays.asList(User.builder().firstName("john").lastName("travolta").build(),
				User.builder().firstName("drew").lastName("barrymore").build());
		log.info("users {}", users);
		return users;
		
	}

}
