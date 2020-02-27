package com.cg.iter.FeedbackMangementSystem;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.iter.feedbackmanagementsystem.dao.impl.TrainingProgramDaoImpl;
import com.cg.iter.feedbackmanagementsystem.service.entity.Center;
import com.cg.iter.feedbackmanagementsystem.service.entity.Course;
import com.cg.iter.feedbackmanagementsystem.service.entity.Trainer;
import com.cg.iter.feedbackmanagementsystem.service.entity.TrainingProgram;

public class TrainingProgramDaoImplTest2 {
	private static TrainingProgramDaoImpl test;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test=new TrainingProgramDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test
	public void testCreate() {
		Set<String> setOne = new HashSet<String>();
		setOne.add("JAVA");
		setOne.add("C");
		setOne.add("PYTHON");
		assertNotEquals(null, test.create(new TrainingProgram("TP_201", 
				new Date(21-6-2019),
				new Course("CD_201","JAVA","It is a object orieneted prgramming lang",2500),
				new Trainer("TR180001", "Vishal", "Bhubaneswar", setOne),
				new Center("CT_202", "Bhubaneswar", "Bhubaneswar,Odisha"))));
	}

	@Test
	public void testUpdate() {
		Set<String> setOne = new HashSet<String>();
		setOne.add("JAVA");
		setOne.add("C");
		setOne.add("PYTHON");
		assertNotEquals(null, test.update(new TrainingProgram("TP_201", 
				new Date(21-6-2019),
				new Course("CD_201","C","It is a object orieneted prgramming lang",2500),
				new Trainer("TR180001", "Vishal", "Bhubaneswar", setOne),
				new Center("CT_202", "Bhubaneswar", "Bhubaneswar,Odisha"))));
	}
	


	@Test
	public void testRetrieveAll() {
		assertNotEquals(null, test.retrieveAll());
	}

	@Test
	public void testRetrieve() {
		assertNotEquals(null, test.retrieve("TP_201"));
	}

}
