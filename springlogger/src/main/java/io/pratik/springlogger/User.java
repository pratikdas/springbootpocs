/**
 * 
 */
package io.pratik.springlogger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Pratik Das
 *
 */
@Builder
@AllArgsConstructor
@Data
public class User {
	private String firstName;
	private String lastName;
	private String city;
}
