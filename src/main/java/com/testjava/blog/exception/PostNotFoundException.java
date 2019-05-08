/**
 * 
 */
package com.testjava.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  Handling exceptions resulting from entering wrong post Id. 
 *  The benefit of this is to prevent the program from being stopped by errors like NullPointerException...
 *  This also allows to understand the behavior of the program during runtime thought messages.
 */

/**
 * @author Arnaud
 *
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Il n'existe pas de post possedant cet identifiant.")
public class PostNotFoundException extends Exception {

	static final long serialVersionUID = -3387516993334229948L;
	
	public PostNotFoundException(String message) {
		super(message);
	}
}
