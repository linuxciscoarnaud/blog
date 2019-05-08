/**
 * 
 */
package com.testjava.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  Handling exceptions resulting from the negligence of certain constraints. 
 *  For example the user failed to fill mandatory information.
 */

/**
 * @author Arnaud
 *
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Des contraintes n'ont pas ete respectees")
public class ConstraintsViolationException  extends Exception {

	static final long serialVersionUID = -1307016903227229948L;
	
	public ConstraintsViolationException(String message) {
		super(message);
	}
}
