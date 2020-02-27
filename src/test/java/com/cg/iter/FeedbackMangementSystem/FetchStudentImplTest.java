package com.cg.iter.FeedbackMangementSystem;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.iter.feedbackmanagementsystem.dao.impl.FetchStudentImpl;

public class FetchStudentImplTest {
	private static FetchStudentImpl test;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test=new FetchStudentImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testRetrieveAll() {
		assertNotEquals(null, test.retrieveAll());
	}

	@Test
	public void testRetrieve() {
		assertNotEquals(null, test.retrieve());
	}

}
