package com.fullteaching.backend.comment;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.fullteaching.backend.user.User;


public class commentTest {
		
	@Test
	public void createComment() {
		Comment comment = new Comment();
		Assertions.assertEquals(0, comment.getId());
	}
	
	@Test
	public void createCommentWithUser() {
		User user = mock(User.class);
		String message = "teste";
		long date = 123;
		Comment comment = new Comment(message, date, user);
		Assertions.assertEquals("teste", comment.getMessage());
		Assertions.assertEquals(123, comment.getDate());
	}
	
	
	@Test
	public void createCommentWithUserAndCommentParent() {
		User user = mock(User.class);
		String message = "teste";
		long date = 123;
		Comment comment = new Comment(message, date, user);
		Assertions.assertEquals("teste", comment.getMessage());
		Assertions.assertEquals(123, comment.getDate());
		User userParent = mock(User.class);
		String messageParent = "teste parent";
		long dateParent = 1234;
		Comment commentParent = new Comment(messageParent, dateParent, userParent, comment);
		Assertions.assertEquals("teste parent", commentParent.getMessage());
		Assertions.assertEquals(1234, commentParent.getDate());
		comment.setCommentParent(commentParent);
		Assertions.assertEquals(commentParent, comment.getCommentParent());
	}
	
	@Test
	public void testId() {
		Comment comment = new Comment();
		comment.setId(3);
		Assertions.assertEquals(3, comment.getId());
	}
	
	@Test
	public void testMessage() {
		Comment comment = new Comment();
		comment.setMessage("teste");
		Assertions.assertEquals("teste", comment.getMessage());
	}
	
	@Test
	public void testDate() {
		Comment comment = new Comment();
		comment.setDate(1220227200);
		Assertions.assertEquals(1220227200, comment.getDate());
	}
	
	@Test
	public void testReplies() {
		User user = mock(User.class);
		String message = "teste";
		long date = 123;
		Comment comment = new Comment(message, date, user);
		User user2 = mock(User.class);
		String message2 = "teste 2";
		long date2 = 1234;
		Comment comment2 = new Comment(message2, date2, user2);
		List<Comment> listComment = new ArrayList<Comment>();
		listComment.add(comment2);
		comment.setReplies(listComment);
		Assertions.assertEquals(listComment, comment.getReplies());
	}
	
	//Como User est� mockado fiz um teste com o nome dele
	
	@Test
	public void testUser() {
		User user = mock(User.class);
		Mockito.when(user.getName()).thenReturn("User");
		Assertions.assertEquals("User", user.getName());
	}
	
}