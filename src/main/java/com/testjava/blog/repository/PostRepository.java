/**
 * 
 */
package com.testjava.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testjava.blog.model.Post;

/**
 *  PostRepository repository for accessing the data from the database.
 */

/**
 * @author Arnaud
 *
 */


public interface PostRepository extends JpaRepository<Post, String> {

	
}
