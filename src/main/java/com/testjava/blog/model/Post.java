/**
 * 
 */
package com.testjava.blog.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Post domain model
 */

/**
 * @author Arnaud
 *
 */

@Entity
public class Post {

	@Id
	@Column(length = 1)
	private String id;
	
	@Column(nullable = false)
    @NotNull(message = "Le titre du post ne peu pas etre vide")
	private String postTitle;
	
	@Column(nullable = false)
    @NotNull(message = "Le contenu du post ne peu pas etre vide")
	private String postContent;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateTimePosted;
	
	public Post() {
		
	}

	// Getters and Setters
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public ZonedDateTime getDateTimePosted() {
		return dateTimePosted;
	}

	public void setDateTimePosted(ZonedDateTime dateTimePosted) {
		this.dateTimePosted = dateTimePosted;
	}
}
