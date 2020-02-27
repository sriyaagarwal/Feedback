package com.cg.iter.feedbackmanagementsystem.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.service.entity.*;
public class DataBaseEntry {
	private static Set<TrainingProgram> trainingProgram = new HashSet<TrainingProgram>();
	private static Set<Center> center = new HashSet<Center>();
	private static Set<Student> student = new HashSet<Student>();
	private static Set<Feedback> feedback = new HashSet<Feedback>();
	private static  Set<String> skillTest;
	private static Set<Trainer> trainer=new HashSet<Trainer>();
	public static Set<Course> course= new HashSet<Course>();
	static {
		student.add(new Student("ST_2001", "Tushar"));
		student.add(new Student("ST_2002", "Sashi"));
		student.add(new Student("ST_2003", "Sriya"));
		student.add(new Student("ST_2040", "Vishal"));
		course.add(new Course("CD_201","JAVA","It is a object orieneted prgramming lang",2500));
		course.add(new Course("CD_202","C","It is a prgramming lang",2000));
		course.add(new Course("CD_203","C++","It is programming lang",2600));
		course.add(new Course("CD_204","C#","It is programming lang",1000));
		course.add(new Course("CD_205","Html","We can create web pages",2050));
		course.add(new Course("CD_206","Python","It can be used on a server to create web applications.",3000));
		course.add(new Course("CD_207","Android","We can develop app",5000));
		course.add(new Course("CD_208","PHP","It is a serverScripting lang",3500));
		Set<String>  setOne=new HashSet<String>();
		setOne.add("JAVA");
		setOne.add("C");
		setOne.add("PYTHON");
		skillTest=setOne;
		trainer.add(new Trainer("TR180001", "Bishal", "Bhubaneswar", setOne));
		Set<String> setTwo=new HashSet<String>();
		setTwo.add("ADVANCEJ");
		setTwo.add("ANDROID");
		trainer.add(new Trainer("TR180201", "Sachiket", "Bhubaneswar", setTwo));
		Set<String> setThree=new HashSet<String>();
		setThree.add("C");
		setThree.add("C++");
		setThree.add("KOTLIN");
		trainer.add(new Trainer("TR181001", "Vishal", "Cuttack", setThree));
		
		center.add(new Center("CT_202", "Cuttack", "Cuttack,Odisha"));
		center.add(new Center("CT_201", "Bhubaneswar", "Bhubaneswar,Odisha"));
		trainingProgram.add(new TrainingProgram("TP_201", 
				new Date(21-6-2019),
				new Course("CD_201","JAVA","It is a object orieneted prgramming lang",2500),
				new Trainer("TR180001", "Bishal", "Bhubaneswar", setOne),
				new Center("CT_202", "Cuttack", "Cuttack,Odisha")));
		Feedback f1 = new Feedback(new Student("ST_2001", "Tushar"), new TrainingProgram("TP_201", 
				new Date(21-6-2019),
				new Course("CD_201","JAVA","It is a object orieneted prgramming lang",2500),
				new Trainer("TR180001", "Bishal", "Bhubaneswar", setOne),
				new Center("CT_202", "Cuttack", "Cuttack,Odisha")), 2, 4, 5, 1, 2);
		feedback.add(f1);
	}

	public static Set<TrainingProgram> getTrainingProgram() {
		return trainingProgram;
	}

	public static void setTrainingProgram(Set<TrainingProgram> trainingProgram) {
		DataBaseEntry.trainingProgram = trainingProgram;
	}

	public static Set<Center> getCenter() {
		return center;
	}

	public static void setCenter(Set<Center> center) {
		DataBaseEntry.center = center;
	}

	public static Set<String> getSkillTest() {
		return skillTest;
	}

	public static void setSkillTest(Set<String> skillTest) {
		DataBaseEntry.skillTest = skillTest;
	}

	public static Set<Course> getCourse() {
		return course;
	}

	public static void setCourse(Set<Course> course) {
		DataBaseEntry.course = course;
	}

	public static void setStudent(Set<Student> student) {
		DataBaseEntry.student = student;
	}

	public static Set<Trainer> getTrainer() {
		return trainer;
	}

	public static void setTrainer(Set<Trainer> trainer) {
		DataBaseEntry.trainer = trainer;
	}

	public static Set<Student> infoOfStudent() {
		return student;
	}

	public static Set<Feedback> getFeedback() {
		return feedback;
	}

	public static void setFeedback(Set<Feedback> feedback) {
		DataBaseEntry.feedback = feedback;
	}

	public static Set<Feedback> infoOfFeedback() {
		return feedback;
	}
	public static Set<Course> infoDb() {
		System.out.println(course);
		return course;


	}
	
	public static Set<Student> getStudent() {
		return student;
	}


	public static Set<Trainer> infoTrainers() {
		//System.out.println(trainer);
		return trainer;
	}
	public static Set<TrainingProgram> getTrainingPrograms(){
		return trainingProgram;
		
	}

}
