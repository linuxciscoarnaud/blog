/**
 * 
 */
package com.testjava.blog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.testjava.blog.model.Comment;

/**
 * Integration tests
 *
 */

/**
 * @author Arnaud
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BlogRestControllerIntegrationTest {

	@Autowired
    private TestRestTemplate restTemplate;
	
	@LocalServerPort
    private int port;
	
	private String getRootUrl() {
		return "http://localhost:" + port;
	}
	
	@Test
    public void contextLoads() {
		
	}
	
	
	/**
     * Test for creating a new comment.
     *
     */
	@Test
	public void testCreateComment() {
		
		Comment comment = new Comment();
		
		comment.setCommentContent("This statement seems right, but leaves room for discussions");
		ResponseEntity<Comment> postResponse = restTemplate.postForEntity(getRootUrl() + "/post/1/comment", comment, Comment.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	
	/**
     * Test for searching comments by post Id.
     *
     */
	@Test
	public void testGetCommentsByPostId() {
		
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/post/1/comments", HttpMethod.GET, entity, String.class);
		assertNotNull(response.getBody());
	}
	
	
	/**
     * Test for updating a comment.
     *
     */
	@Test
	public void testUpdateComment() {
		
		String commentId = "214"; // Assuming that this comment Id is already stored in the database
                                  // If that's not the case, then not comment will be modified
		
		Comment comment = restTemplate.getForObject(getRootUrl() + "/post/1/comments/" + commentId, Comment.class);
		comment.setCommentContent("I change my mind. I was wrong");
		restTemplate.put(getRootUrl() + "/post/1/comments/" + commentId, comment);
		Comment updatedComment = restTemplate.getForObject(getRootUrl() + "/post/1/comments/" + commentId, Comment.class);
		assertNotNull(updatedComment);
	}
	
	
	/**
     * Test for deleting a comment.
     *
     */
	@Test
	public void testDeleteComment() {
		
		String commentId = "214"; // Assuming that this comment Id is already stored in the database
		                          // If that's not the case, then not record will be deleted from the database
		
		Comment comment = restTemplate.getForObject(getRootUrl() + "/post/1/comments/" + commentId, Comment.class);
		assertNotNull(comment);
		restTemplate.delete(getRootUrl() + "/post/1/comments/" + commentId);
		try {
			comment = restTemplate.getForObject(getRootUrl() + "/post/1/comments/" + commentId, Comment.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
