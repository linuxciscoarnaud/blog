/**
 * 
 */
package com.testjava.blog.service.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.testjava.blog.exception.CommentNotFoundException;
import com.testjava.blog.exception.PostNotFoundException;
import com.testjava.blog.model.Comment;

/**
 * Service layer interface in regard with the comments.
 */

/**
 * @author Arnaud
 *
 */


public interface CommentService {

	Comment createComment(String postId, Comment comment) throws PostNotFoundException;
	Page<Comment> getCommentsByPostId(String postId, Pageable pageable) throws PostNotFoundException;
	Comment updateComment(String postId, String commentId, Comment commentToUpdate) throws PostNotFoundException, CommentNotFoundException;
	ResponseEntity<?> deleteComment(String postId, String commentId) throws CommentNotFoundException, PostNotFoundException;
}
