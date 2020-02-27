package com.cg.iter.FeedbackMangementSystem;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.iter.feedbackmanagementsystem.dao.impl.TrainerManagementDaoImpl;
import com.cg.iter.feedbackmanagementsystem.service.entity.Trainer;

public class TrainerManagementDaoImplTest {
	private static TrainerManagementDaoImpl test;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test=new TrainerManagementDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreate() {
		Set<String>  setOne=new HashSet<String>();
		setOne.add("JAVA");
		setOne.add("C");
		setOne.add("PYTHON");
		assertEquals(true,test.create(new Trainer("TR181001", "Vishal", "Cuttack", setOne)));
	}

	@Test
	public void testUpdate() {
		Set<String>  setOne=new HashSet<String>();
		setOne.add("JAVA");
		setOne.add("PYTHON");
		assertEquals(true,test.create(new Trainer("TR180001", "Bishal", "Bhubaneswae", setOne)));
	}

	@Test
	public void testDelete() {
		Set<String> setThree=new HashSet<String>();
		setThree.add("C");
		setThree.add("C++");
		setThree.add("KOTLIN");
		assertEquals(true,test.delete(new Trainer("TR181001", "Vishal", "Cuttack", setThree)));
	}

	@Test
	public void testGetAllTrainers() {
		assertNotEquals(null, test.getAllTrainers());
	}

	@Test
	public void testRetrieveAll() {
		assertNotEquals(null, test.retrieveAll());
	}

}
