/**
 * 
 */
package com.testjava.blog.service.comment;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.testjava.blog.exception.CommentNotFoundException;
import com.testjava.blog.exception.PostNotFoundException;
import com.testjava.blog.model.Comment;
import com.testjava.blog.repository.CommentRepository;
import com.testjava.blog.repository.PostRepository;

/**
 *  Implementation of the service layer regarding the comments
 *  This is where we implement the business logic of the application in regard with comments
 */

/**
 * @author Arnaud
 *
 */

@Service
public class CommentServiceImpl implements CommentService {
	
	private final PostRepository postRepository;
	private final CommentRepository commentRepository;
	
	@Autowired
	public CommentServiceImpl(final PostRepository postRepository, CommentRepository commentRepository) {
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
	}

	/* (non-Javadoc)
	 * @see com.testjava.blog.service.comment.CommentService#createComment(java.lang.String, com.testjava.blog.model.Comment)
	 */
	@Override
	public Comment createComment(String postId, Comment comment) throws PostNotFoundException {
		// TODO Auto-generated method stub
		
		return postRepository.findById(postId).map(post -> {
			comment.setPost(post);
			comment.setDateTimeCommented(ZonedDateTime.now());
			return commentRepository.save(comment);
		}).orElseThrow(() -> new PostNotFoundException(""));
	}

	/* (non-Javadoc)
	 * @see com.testjava.blog.service.comment.CommentService#getCommentsByPostId(java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Comment> getCommentsByPostId(String postId, Pageable pageable) throws PostNotFoundException {
		// TODO Auto-generated method stub
		
		if(!postRepository.existsById(postId)) {
			throw new PostNotFoundException("");
		} else {
			return commentRepository.findByPostId(postId, pageable);
		}
	}

	/* (non-Javadoc)
	 * @see com.testjava.blog.service.comment.CommentService#updateComment(java.lang.String, java.lang.String, com.testjava.blog.model.Comment)
	 */
	@Override
	public Comment updateComment(String postId, String commentId, Comment commentToUpdate)
			throws PostNotFoundException, CommentNotFoundException {
		// TODO Auto-generated method stub
		
		if(!postRepository.existsById(postId)) {
			 throw new PostNotFoundException("");
		} else {
			return commentRepository.findById(commentId).map(comment -> {
				comment.setCommentContent(commentToUpdate.getCommentContent());
				comment.setDateTimeCommented(ZonedDateTime.now()); // We also need to make sure we record the modification time and date
				return commentRepository.save(comment);
			}).orElseThrow(() -> new CommentNotFoundException(""));
		}
	}

	/* (non-Javadoc)
	 * @see com.testjava.blog.service.comment.CommentService#deleteComment(java.lang.String, java.lang.String)
	 */
	@Override
	public ResponseEntity<?> deleteComment(String postId, String commentId)
			throws CommentNotFoundException, PostNotFoundException {
		// TODO Auto-generated method stub
		
		if(!postRepository.existsById(postId)) {
			throw new PostNotFoundException("");
		} else {
			return commentRepository.findByIdAndPostId(commentId, postId).map(comment -> {
				commentRepository.delete(comment);
				return ResponseEntity.ok().build();
			}).orElseThrow(() -> new CommentNotFoundException(""));
		}
	}
}
