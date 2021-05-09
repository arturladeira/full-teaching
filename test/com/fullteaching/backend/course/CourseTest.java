package com.fullteaching.backend.course;

import static org.mockito.Mockito.mock;

import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.session.Session;
import com.fullteaching.backend.user.User;

public class CourseTest {
	
	
	@Test
	public void createCouse() {
		Course course = new Course();
		Assertions.assertEquals(0, course.getId());
	}
	
	
	@Test
	public void createCourseWithTeacher() {
		User teacher = mock(User.class);
		String title = "titulo teste";
		String image = "image teste";
		Course course = new Course(title, image, teacher);
		Assertions.assertEquals("titulo teste", course.getTitle());
		Assertions.assertEquals("image teste", course.getImage());
	}
	
	
	@Test
	public void createCourseWithTeacherAndCourseDetails() {
		User teacher = mock(User.class);
		CourseDetails courseDetails = mock(CourseDetails.class);
		Mockito.when(courseDetails.getInfo()).thenReturn("info teste");
		String title = "titulo teste";
		String image = "image teste";
		Course course = new Course(title, image, teacher, courseDetails);
		Assertions.assertEquals("titulo teste", course.getTitle());
		Assertions.assertEquals("image teste", course.getImage());
		Assertions.assertEquals("info teste", courseDetails.getInfo());
	}
	
	@Test
	public void testId() {
		Course course = new Course();
		course.setId(3);
		Assertions.assertEquals(3, course.getId());
	}
	
	@Test
	public void testIdWithZero() {
		Course course = new Course();
		course.setId(0);
		Assertions.assertEquals(0, course.getId());
	}
	
	@Test
	public void testTitle() {
		Course course = new Course();
		course.setTitle("title teste");
		Assertions.assertEquals("title teste", course.getTitle());
	}
	
	@Test
	public void testImage() {
		Course course = new Course();
		course.setImage("image teste");
		Assertions.assertEquals("image teste", course.getImage());
	}
	
	@Test
	public void testTeacher() {
		Course course = new Course();
		User teacher = mock(User.class);
		Mockito.when(teacher.getName()).thenReturn("Teacher");
		Assertions.assertEquals("Teacher", teacher.getName());
		course.setTeacher(teacher);
		Assertions.assertEquals(teacher, course.getTeacher());
	}
	

	@Test
	public void testCourseDetails() {
		CourseDetails courseDetails = mock(CourseDetails.class);
		Mockito.when(courseDetails.getInfo()).thenReturn("info teste");
		Course course = new Course();
		course.setCourseDetails(courseDetails);
		Assertions.assertEquals("info teste", course.getCourseDetails().getInfo());
	}
	
	@Test
	public void testAttenders() {
		User teacher = mock(User.class);
		Mockito.when(teacher.getName()).thenReturn("Teacher");
		Course course = new Course();
		Set<User> user = new HashSet<User>();
		user.add(teacher);
		course.setAttenders(user);
		Assertions.assertEquals(user, course.getAttenders());
	}
	
	@Test
	public void testSessions() {
		Session session = mock(Session.class);
		Mockito.when(session.getTitle()).thenReturn("Session");
		Course course = new Course();
		Set<Session> sessionList = new HashSet<Session>();
		sessionList.add(session);
		course.setSessions(sessionList);
		Assertions.assertEquals(sessionList, course.getSessions());
	}
	
	@Test
	public void testeCourseNull() {
		Course course = new Course();
		Assert.assertFalse(course.equals(null));
	}

	@Test
	public void testSameInstance() {
		User teacher = Mockito.mock(User.class);
		Course anotherCourse = new Course("Teste titulo", " teste imagem", teacher);
		Assert.assertTrue(anotherCourse.equals(anotherCourse));
	}

	@Test
	public void testEqualsDiffentClasses() {
		Course course = new Course();
		User teacher = Mockito.mock(User.class);
		Assert.assertFalse(course.equals(teacher));
	}
	
	@Test
	public void testeEquals() {
		Course course = new Course();
		Course anotherCourse = new Course();
		Course differentCourse = new Course();
		course.setId(1);
		anotherCourse.setId(1);
		differentCourse.setId(2);
		Assert.assertTrue(course.equals(anotherCourse) && !course.equals(differentCourse));
	}
	
	@Test
	public void testToString() {
		Course course = new Course();
		String tittle = "Titulo teste";
		User theacher = Mockito.mock(User.class);
		Set<User> students = new HashSet<>();
		User student = Mockito.mock(User.class);
		students.add(student);
		Set<Session> sessions = new HashSet<>();
		Session session = Mockito.mock(Session.class);
		sessions.add(session);
		course.setTitle(tittle);
		course.setTeacher(theacher);
		course.setAttenders(students);
		course.setSessions(sessions);
		String mensagem = "Course[title: \"" + tittle + "\", teacher: \"" + theacher.getNickName() + "\", #attenders: " + students.size() + ", #sessions: " + sessions.size() + "]";
		Assert.assertEquals(mensagem, course.toString());
	}
		
}
