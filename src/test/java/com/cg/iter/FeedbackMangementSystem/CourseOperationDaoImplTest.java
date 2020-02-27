package com.cg.iter.FeedbackMangementSystem;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.iter.feedbackmanagementsystem.dao.impl.CourseOperationDaoImpl;
import com.cg.iter.feedbackmanagementsystem.service.entity.Course;
public class CourseOperationDaoImplTest {

	private static CourseOperationDaoImpl test;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test=new CourseOperationDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreate() {
		boolean actual=test.create(new Course("CD_221","JAVA","It is a object oriented prgramming lang",2500));
		assertEquals(true, actual);
	}

	@Test
	public void testUpdate() {
		boolean actual=test.update(new Course("CD_221","JAVA","It is a object oriented prgramming lang",2500));
		assertEquals(true, actual);
		
	}

	@Test
	public void testDelete() {
		boolean actual=test.delete(new Course("CD_201","JAVA","It is a object oriented prgramming lang",2500));
		assertEquals(true, actual);
	}

	@Test
	public void testRetrieveAll() {
		Set<Course> actual=test.retrieveAll();
		assertNotEquals(null, actual);
	}
	@Test
	public void testRetrieve() {
		assertNotNull(test.retrieve("CD_201"));
	}

}
