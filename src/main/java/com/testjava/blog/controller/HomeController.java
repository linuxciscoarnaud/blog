/**
 * 
 */
package com.testjava.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

/**
 * This controller will just allow to redirect the
 */

/**
 * @author Arnaud
 *
 */

@Controller
@ApiIgnore
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "redirect:swagger-ui.html";
	}
}
