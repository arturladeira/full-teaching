package com.fullteaching.backend.session;

import static org.mockito.Mockito.mock;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.junit.Assert;

import com.fullteaching.backend.course.Course;

public class sessionTest {
	
	@Test
	public void createSession() {
		Session session = new Session();
		Assertions.assertEquals(0, session.getId());
	}
	
	@Test
	public void createSessionWithParams() {
		String title = "Teste Title";
		String description = "Teste Description";
		long date = 1234;
		Session session = new Session(title, description, date);
		Assertions.assertEquals("Teste Title", session.getTitle());
		Assertions.assertEquals("Teste Description", session.getDescription());
		Assertions.assertEquals(1234, session.getDate());
	}

	@Test
	public void createSessionWithCourse() {
		Course course = mock(Course.class);
		Mockito.when(course.getTitle()).thenReturn("title teste");
		String title = "Teste Title";
		String description = "Teste Description";
		long date = 1234;
		Session session = new Session(title, description, date, course);
		Assertions.assertEquals("title teste", session.getCourse().getTitle());
		Assertions.assertEquals("Teste Title", session.getTitle());
		Assertions.assertEquals("Teste Description", session.getDescription());
		Assertions.assertEquals(1234, session.getDate());
		Assert.assertEquals(course, session.getCourse());
	}
	
	@Test
	public void testId() {
		Session session = new Session();
		session.setId(3);
		Assertions.assertEquals(3, session.getId());
	}
	
	@Test
	public void testIdWithZero() {
		Session session = new Session();
		session.setId(0);
		Assertions.assertEquals(0, session.getId());
	}
	
	@Test
	public void testTitle() {
		Session session = new Session();
		session.setTitle("Teste Title");
		Assertions.assertEquals("Teste Title", session.getTitle());
	}
	
	@Test
	public void testDescription() {
		Session session = new Session();
		session.setDescription("Teste Description");
		Assertions.assertEquals("Teste Description", session.getDescription());
	}
	
	@Test
	public void testDate() {
		Session session = new Session();
		session.setDate(1234);
		Assertions.assertEquals(1234, session.getDate());
	}
	
	@Test
	public void testCourse() {
		Course course = mock(Course.class);
		Mockito.when(course.getTitle()).thenReturn("Course teste");
		Session session = new Session();
		session.setCourse(course);
		Assertions.assertEquals("Course teste", session.getCourse().getTitle());
	}
	
	@Test
	public void testeSessionNull() {
		Session session = new Session();
		Assert.assertFalse(session.equals(null));
	}
	
	@Test
	public void testEquals() {
		Session session = new Session();
		Session anotherSession = new Session();
		Session differentSession = new Session();
		session.setId(0);
		anotherSession.setId(0);
		differentSession.setId(2);
		Assert.assertTrue(session.equals(anotherSession) && !session.equals(differentSession));
	}
	
	@Test
	public void testeEqualsNulo() {
		Session session = new Session();
		Assert.assertFalse(session.equals(null));
	}
	
	@Test
	public void testEqualsSameInstance() {
		Session anotherSession = new Session("outro titulo", "outra descrição", (long) 12);
		Assert.assertTrue(anotherSession.equals(anotherSession));
	}
	
	@Test
	public void testEqualsAnotherClass() {
		Session session = new Session();
		Course course = Mockito.mock(Course.class);
		Assert.assertFalse(session.equals(course));
	}
	
	@Test
	public void testeToString() {
		Session session = new Session();
		session.setTitle("Titulo Teste");
		session.setDescription("Descricao Teste");
		session.setDate(1234);
		String string = "Session[title: \"" + session.getTitle() + "\", description: \"" + session.getDescription() + "\", date: \"" + session.getDate() + "\"]";
		Assert.assertEquals(string, session.toString());
	}

}
