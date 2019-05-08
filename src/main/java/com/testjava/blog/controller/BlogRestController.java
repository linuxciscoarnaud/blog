/**
 * 
 */
package com.testjava.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testjava.blog.exception.CommentNotFoundException;
import com.testjava.blog.exception.PostNotFoundException;
import com.testjava.blog.model.Comment;
import com.testjava.blog.service.comment.CommentService;

/**
 *  REST API intended to serve the blog.
 *  It performs CRUD operations on both Post and Comment entities.
 */


/**
 * @author Arnaud
 *
 */

@RestController
@RequestMapping("post")
public class BlogRestController {

	private final CommentService commentService;
	
	@Autowired
	public BlogRestController(CommentService commentService) {
		this.commentService = commentService;
	}
	
    
    /**
     * Creates a new comment related to a post which has 1 as Id.
     *
     * @param postId as PathVariable
     * @param comment as RequestBody
     * @return created comment
	 * @throws PostNotFoundException 
     */
	@PostMapping("/{postId}/comment")
	public Comment createComment(@PathVariable (value = "postId") String postId, 
			                     @Valid @RequestBody Comment comment) throws PostNotFoundException {
		
		return commentService.createComment(postId, comment);
	}
	
	
	/**
     * Displays all the comments related to a post which has 1 as Id.
     *
     * @param postId as PathVariable
     * @param pageable 
     * @return page of comments
	 * @throws PostNotFoundException 
     */
	@GetMapping("/{postId}/comments")
	public Page<Comment> getCommentsByPostId(@PathVariable (value = "postId") String postId, 
			                                 Pageable pageable) throws PostNotFoundException {
		
		return commentService.getCommentsByPostId(postId, pageable);
		
	}
	
	
	/**
     * Update/Modify a comment related to a post which has 1 as Id.
     *
     * @param postId as PathVariable
     * @param commentId as PathVariable
     * @param commentToUpdate as RequestBody
     * @return Updated comment
	 * @throws PostNotFoundException 
	 * @throws CommentNotFoundException
     */
	@PutMapping("/{postId}/comments/{commentId}")
	public Comment updateComment(@PathVariable (value = "postId") String postId,
                                 @PathVariable (value = "commentId") String commentId,
                                 @Valid @RequestBody Comment commentToUpdate) throws PostNotFoundException, 
	                                                                                 CommentNotFoundException {
		
		return commentService.updateComment(postId, commentId, commentToUpdate);
	}
	
	
	/**
     * Deletes a comment related to a post which has 1 as Id.
     *
     * @param postId as PathVariable
     * @param commentId as PathVariable
     * @return ResponseEntity
	 * @throws PostNotFoundException 
	 * @throws CommentNotFoundException
     */
	@DeleteMapping("/{postId}/comments/{commentId}")
	 public ResponseEntity<?> deleteComment(@PathVariable (value = "postId") String postId,
                                            @PathVariable (value = "commentId") String commentId) throws CommentNotFoundException, 
	                                                                                                     PostNotFoundException {
		
		return commentService.deleteComment(postId, commentId);
	}
}
