package com.cg.iter.feedbackmanagementsystem.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.cg.iter.feedbackmanagementsystem.dao.DataBaseEntry;
import com.cg.iter.feedbackmanagementsystem.enumvariables.Skills;
import com.cg.iter.feedbackmanagementsystem.exception.*;
import com.cg.iter.feedbackmanagementsystem.service.*;
import com.cg.iter.feedbackmanagementsystem.service.entity.*;
import com.cg.iter.feedbackmanagementsystem.service.impl.*;
import com.cg.iter.feedbackmanagementsystem.services.CoordinatorService;


public class CoordinatorController 
{
	private static Logger log=Logger.getLogger(CoordinatorController.class);
	public static CoordinatorService coordinatorService=new CoordinatorService();
	public  static void addCourse() throws InvalidCourseIdException, InvalidCourseNameException, CourseNullException 
	{
		coordinatorService.addCourse();
		DataBaseEntry.infoDb();
	}

	//	
	public static void deleteCourse() throws InvalidCourseIdException, InvalidCourseNameException {
		CoordinatorService.deleteCourse();
	}

	public static void modifyCourse() throws InvalidCourseNameException, InvalidCourseIdException {
		CoordinatorService.modifyCourse();
	}

	public static Set<Course>  getAllCourse() {
		return coordinatorService.getAllCourse();

	}

	public static void viewdefaultlistController() {

		//List<String> viewDefaulterList = new ArrayList<String>();
		// List<String>list=new ArrayList<String>();
		FeedbackOperationImpl obj = new FeedbackOperationImpl();

		Set<Student> list = obj.viewDefaulterList();
		// System.out.println(obj.viewDefaulterList());
		//list.addAll(obj.viewDefaulterList());

		System.out.println("the defaulter students are:" + list);

	}

	public static void viewFeedbackReportController() {

		FeedbackOperationImpl objct=new FeedbackOperationImpl();

		Set<Feedback> set=new HashSet<Feedback>();
		set=objct.viewFeedbackReport();
		for(Feedback feed:set) {
			System.out.println(feed);

		}

	}

	public static void deleteProgram() {
		Set<TrainingProgram> trainingProgram = DataBaseEntry.getTrainingProgram();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Training Program ID");
		String tpID=sc.next();





		Iterator value = trainingProgram.iterator();

		while(value.hasNext())
		{
			TrainingProgram tt=(TrainingProgram)value.next();

			if((tt.getTrainingId()).equals(tpID))
			{
				//System.out.println(tt.getTrainerName()+" We are fetching your skills please wait");
				trainingProgram.remove(tt);
				log.info("Removed Program"+tt.getTrainingId());
				System.out.println("Training Program"+tpID+"successfully deleted");
			}

		}

	}

	public static void getProgramDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter program id ");
		String id=sc.next();
		System.out.println(CoordinatorService.getTrainingProgramDetails(id));

	}
	public static void getAllRunningPrograms() {
		System.out.println(coordinatorService.getAllTrainingPrograms());

	}
	public static void addStudent() {
		Set<Student> sList=DataBaseEntry.getStudent();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student ID");
		String id=sc.next();
		System.out.println("Enter student name");
		String name=sc.next();
		sList.add(new Student(id,name));

		log.info("Added Student"+id);
	}
	public static void removeStudent() 
	{
		Set<Student> sList=DataBaseEntry.getStudent();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student ID");
		String id=sc.next();
		Student st=null;
		for (Iterator iterator = sList.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			if(student.getStudentId().equalsIgnoreCase(id)) {
				st=student;
			}
		}
		sList.remove(st);
		log.info(st.getStudentId());
	}
	public static void modifyStudent() {
		Set<Student> sList=DataBaseEntry.getStudent();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student ID to modify");
		String id=sc.next();
		System.out.println("Enter student name");
		String name=sc.next();
		Student st =null;
		for (Iterator iterator = sList.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			if(student.getStudentId().equalsIgnoreCase(id)) {
				st = student;

			}
		}
		sList.remove(st);
		sList.add(new Student(id,name));
		log.info("Modified"+st+(new Student(id,name)));
	}

	public static void createProgram() {
		Set<TrainingProgram> trainingProgram = DataBaseEntry.getTrainingPrograms();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Training Program ID");
		String tpID=sc.next();
		System.out.println("Enter the Date ");
		String date = sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date date2=null;
		try {
			//Parsing the String
			date2 = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Which course?");
		for (Skills s : Skills.values())  
			System.out.println(s);
		String lang=sc.next();
		Course course = null;
		Set<Course> courses=DataBaseEntry.course;
		for (Iterator iterator = courses.iterator(); iterator.hasNext();) {
			Course c = (Course) iterator.next();

			if(c.getCourseName().equalsIgnoreCase(lang)) {
				course=c;
			}

		}

		System.out.println("Which trainer?");
		Trainer trainer = null;
		Set<Trainer> trainers=DataBaseEntry.getTrainer();
		for (Iterator iterator = trainers.iterator(); iterator.hasNext();) {
			Trainer t = (Trainer) iterator.next();
			System.out.println(t.getTrainerName());

		}
		String tr=sc.next();
		for (Iterator iterator = trainers.iterator(); iterator.hasNext();) {
			Trainer t = (Trainer) iterator.next();

			if(t.getTrainerName().equalsIgnoreCase(tr))
			{
				trainer=t;
			}
		}


		System.out.println("Which center?");

		Center center = null;
		Set<Center> centers=DataBaseEntry.getCenter();
		for (Iterator iterator = centers.iterator(); iterator.hasNext();) {
			Center c = (Center) iterator.next();
			System.out.println(c.getCenterName());
		}
		String ct=sc.next();
		for (Iterator iterator = centers.iterator(); iterator.hasNext();) {
			Center c = (Center) iterator.next();

			if(c.getCenterName().equalsIgnoreCase(ct))
			{
				center=c;
			}
		}
		log.info("Added training Program"+tpID);
		CoordinatorService.createTrainingProgramService(new TrainingProgram(tpID, date2, course, trainer, center));



	}

	public static void UpdateTrainingProgram() {
		Set<TrainingProgram> trainingProgram = DataBaseEntry.getTrainingPrograms();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Training Program ID");
		String tpID=sc.next();
		System.out.println("Enter the Date ");
		String date = sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date date2=null;
		try {
			//Parsing the String
			date2 = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Which course?");
		for (Skills s : Skills.values())  
			System.out.println(s);
		String lang=sc.next();
		Course course = null;
		Set<Course> courses=DataBaseEntry.course;
		for (Iterator iterator = courses.iterator(); iterator.hasNext();) {
			Course c = (Course) iterator.next();

			if(c.getCourseName().equalsIgnoreCase(lang)) {
				course=c;
			}

		}

		System.out.println("Which trainer?");
		Trainer trainer = null;
		Set<Trainer> trainers=DataBaseEntry.getTrainer();
		for (Iterator iterator = trainers.iterator(); iterator.hasNext();) {
			Trainer t = (Trainer) iterator.next();
			System.out.println(t.getTrainerName());

		}
		String tr=sc.next();
		for (Iterator iterator = trainers.iterator(); iterator.hasNext();) {
			Trainer t = (Trainer) iterator.next();

			if(t.getTrainerName().equalsIgnoreCase(tr))
			{
				trainer=t;
			}
		}


		System.out.println("Which center?");

		Center center = null;
		Set<Center> centers=DataBaseEntry.getCenter();
		for (Iterator iterator = centers.iterator(); iterator.hasNext();) {
			Center c = (Center) iterator.next();
			System.out.println(c.getCenterName());
		}
		String ct=sc.next();
		for (Iterator iterator = centers.iterator(); iterator.hasNext();) {
			Center c = (Center) iterator.next();

			if(c.getCenterName().equalsIgnoreCase(ct))
			{
				center=c;
			}
		}
		TrainingProgram tp1=null;
		TrainingProgram tp=(new TrainingProgram(tpID, date2, course, trainer, center));
		for (Iterator iterator = trainingProgram.iterator(); iterator.hasNext();) {
			TrainingProgram t = (TrainingProgram) iterator.next();
			if(t.getTrainingId().equalsIgnoreCase(tp.getTrainingId()))
			{
				tp1=t;
			}
		}
		trainingProgram.remove(tp1);
		trainingProgram.add(tp);

		log.info("Updated training Program"+tpID);
		System.out.println(trainingProgram);




	}

	public static void getAllStudentDetails() {
		System.out.println(DataBaseEntry.getStudent());

	}
}

