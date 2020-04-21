/**
 * 
 */
package com.pratik.todolistwithtests;

import lombok.Builder;
import lombok.Data;

/**
 * @author pratikdas
 *
 */
@Data
@Builder
public class TodoItem {
	private String id;
	private String name;
	private String status;

}
