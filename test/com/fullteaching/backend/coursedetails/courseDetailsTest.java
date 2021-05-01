package com.fullteaching.backend.coursedetails;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.filegroup.FileGroup;
import com.fullteaching.backend.forum.Forum;

public class courseDetailsTest {
	
	@Test
	public void createCouseDetails() {
		CourseDetails courseDetails = new CourseDetails();
		Assertions.assertEquals(0, courseDetails.getId());
	}
	
	@Test
	public void createCouseDetailsWithCourse() {
		Course course = mock(Course.class);
		Mockito.when(course.getTitle()).thenReturn("title teste");
		CourseDetails courseDetails = new CourseDetails(course);
		Assertions.assertEquals("title teste", courseDetails.getCourse().getTitle());
	}
	
	
	@Test
	public void testId() {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(3);
		Assertions.assertEquals(3, courseDetails.getId());
	}
	
	@Test
	public void testInfo() {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setInfo("info teste");
		Assertions.assertEquals("info teste", courseDetails.getInfo());
	}
	
	@Test
	public void testForum() {
		Forum forum = mock(Forum.class);
		Mockito.when(forum.isActivated()).thenReturn(true);
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setForum(forum);
		Assertions.assertEquals(true, courseDetails.getForum().isActivated());
	}
	
	@Test
	public void testFiles() {
		CourseDetails courseDetails = new CourseDetails();
		FileGroup fileGroup = mock(FileGroup.class);
		Mockito.when(fileGroup.getTitle()).thenReturn("file group teste");
		List<FileGroup> listFileGroup = new ArrayList<FileGroup>();
		listFileGroup.add(fileGroup);
		courseDetails.setFiles(listFileGroup);
		Assertions.assertEquals(listFileGroup, courseDetails.getFiles());
	}
	
	@Test
	public void testCourse() {
		Course course = mock(Course.class);
		Mockito.when(course.getTitle()).thenReturn("Course teste");
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setCourse(course);
		Assertions.assertEquals("Course teste", courseDetails.getCourse().getTitle());
	}
	
}
