/**
 * 
 */
package com.testjava.blog.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.testjava.blog.util.IdGenerator;

/**
 * Comment domain model
 */

/**
 * @author Arnaud
 *
 */

@Entity
public class Comment {

	@Id
	@GeneratedValue(generator = IdGenerator.generatorName)
	@GenericGenerator(name = IdGenerator.generatorName, strategy = "com.testjava.blog.util.IdGenerator")
	@Column(length = 3)
	private String id;
	
	@Column(nullable = false)
    @NotNull(message = "Le commentaire ne peu pas etre vide")
	private String commentContent;
	
	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateTimeCommented;
	
	@ManyToOne
	@JoinColumn (name = "post_id")
	private Post post;
	
	public Comment() {
		
	}

	// Getters and Setters
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public ZonedDateTime getDateTimeCommented() {
		return dateTimeCommented;
	}

	public void setDateTimeCommented(ZonedDateTime dateTimeCommented) {
		this.dateTimeCommented = dateTimeCommented;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
