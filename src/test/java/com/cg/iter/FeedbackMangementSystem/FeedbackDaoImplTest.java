package com.cg.iter.FeedbackMangementSystem;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.iter.feedbackmanagementsystem.dao.impl.FeedbackDaoImpl;
import com.cg.iter.feedbackmanagementsystem.exception.EmptyFeedbackException;
import com.cg.iter.feedbackmanagementsystem.service.entity.Center;
import com.cg.iter.feedbackmanagementsystem.service.entity.Course;
import com.cg.iter.feedbackmanagementsystem.service.entity.Feedback;
import com.cg.iter.feedbackmanagementsystem.service.entity.Student;
import com.cg.iter.feedbackmanagementsystem.service.entity.Trainer;
import com.cg.iter.feedbackmanagementsystem.service.entity.TrainingProgram;

public class FeedbackDaoImplTest {

	private static FeedbackDaoImpl test;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test=new FeedbackDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddFeedback() throws EmptyFeedbackException {
		Set<String>  setOne=new HashSet<String>();
		setOne.add("JAVA");
		setOne.add("C");
		setOne.add("PYTHON");
		Set<String> skillTest = setOne;
		boolean actual=test.addFeedback(new Student("ST_2001", "Alisha"), new TrainingProgram("TP_201", 
				new Date(21-6-2019),
				new Course("CD_201","JAVA","It is a object oriented prgramming lang",2500),
				new Trainer("TR180001", "Vishal", "Bhubaneswar", setOne),
				new Center("CT_202", "Bhubaneswar", "Bhubaneswar,Odisha")),2,3,4,1,1);
		assertEquals(true, actual);
	}

	

	@Test
	public void testRetrieveAll() {
		Set<Feedback> actual=test.retrieveAll();
		assertNotEquals(null, actual);
	}
}
