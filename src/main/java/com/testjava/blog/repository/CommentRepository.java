/**
 * 
 */
package com.testjava.blog.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.testjava.blog.model.Comment;

/**
 *  CommentRepository repository for accessing the data from the database.
 */

/**
 * @author Arnaud
 *
 */

public interface CommentRepository extends JpaRepository<Comment, String> {

	Page<Comment> findByPostId(String postId, Pageable pageable);
	Optional<Comment> findByIdAndPostId(String Id, String postId);
	
}
