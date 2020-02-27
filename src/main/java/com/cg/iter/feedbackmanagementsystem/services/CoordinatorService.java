
package com.cg.iter.feedbackmanagementsystem.services;
import org.apache.log4j.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.dao.DataBaseEntry;
import com.cg.iter.feedbackmanagementsystem.exception.CourseNullException;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidCourseIdException;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidCourseNameException;
import com.cg.iter.feedbackmanagementsystem.service.entity.Center;
import com.cg.iter.feedbackmanagementsystem.service.entity.Course;
import com.cg.iter.feedbackmanagementsystem.service.entity.Student;
import com.cg.iter.feedbackmanagementsystem.service.entity.Trainer;
import com.cg.iter.feedbackmanagementsystem.service.entity.TrainingProgram;
import com.cg.iter.feedbackmanagementsystem.service.impl.*;

public class CoordinatorService {
	private static Logger log=Logger.getLogger(CoordinatorService.class);


	static CourseOperationImpl courseOperation=new CourseOperationImpl();

	static TrainingProgramImpl trainingProgramOperation= new TrainingProgramImpl();

	static FeedbackOperationImpl feedbackOperation=new FeedbackOperationImpl();
	static TrainerManagementImpl trainerOperation =new TrainerManagementImpl();

	public boolean enrollParticpant(Student student, TrainingProgram trainingProgram) {
		// TODO implement here
		return false;
	}
	public boolean validateCourseAddition(Course course) {
		// TODO implement here
		return false;
	}
	public static TrainingProgram getTrainingProgramDetails(String id) {
		return(trainingProgramOperation.retrieve(id));
	}
	public   boolean addCourse() throws InvalidCourseIdException, InvalidCourseNameException, CourseNullException 
	{

		Scanner scanner = new Scanner(System.in);
		System.out.println("Before adding course:\n");
		Set<Course> courses = DataBaseEntry.infoDb();
		System.out.println("Enter Course Id:\n");
		String courseId = scanner.next();
		System.out.println("enter Course Name:\n");
		String courseName = scanner.next();
		System.out.println("Enter Course Description:\n");
		String courseDesc = scanner.next();
		System.out.println("Enter Course Fees:\n");
		int courseCharges = scanner.nextInt();
		System.out.println("After courses entered:");
		Course course = new Course(courseId, courseName, courseDesc, courseCharges);
		log.info("Add Course : "+courseId);
		return(courseOperation.addCourse(course));



	}
	public static void deleteCourse() throws InvalidCourseIdException, InvalidCourseNameException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Before removing course:\n");

		Set<Course> course =DataBaseEntry.infoDb();
		System.out.println("Enter Course Id:\n");
		String courseId = scanner.next();

		Course courseTemp = null;
		for (Course cors : course) {
			if (cors.getCourseId().equals(courseId)) {
				courseTemp = cors;
				break;
			}
		}
		if (courseTemp != null) {
			course.remove(courseTemp);
		}
		else {
			throw new InvalidCourseIdException("Please enter a valid Course Id");
		}

		log.info("Removed Course : "+courseId);
		System.out.println("After removing course" + course);
	}

	public static boolean modifyCourse() throws InvalidCourseNameException, InvalidCourseIdException {
		Scanner scanner = new Scanner(System.in);
		Set<Course> course = DataBaseEntry.infoDb();

		System.out.println("enter Course ID for updation:\n");
		String cID= scanner.next();

		System.out.println("enter Course Name:\n");
		String courseName = scanner.next();
		System.out.println("Enter Course Description:\n");
		String courseDesc = scanner.next();
		System.out.println("Enter Course Fees:\n");
		int courseCharges = scanner.nextInt();
		System.out.println("After courses entered:");

		log.info("Modified Course : "+cID);
		return(courseOperation.modifyCourse(new Course(cID, courseName, courseDesc, courseCharges))) ;
	}
	public Set<Course> getAllCourse() {
		return courseOperation.getAllCourse();
	}


	public void viewDefaultList() {
		feedbackOperation.viewDefaulterList();
	}
	public void viewReport() {
		feedbackOperation.viewFeedbackReport();
	}
	public static boolean createTrainingProgramService(TrainingProgram trainingProgram) {
		return (trainingProgramOperation.createProgram(trainingProgram));

	}
	public boolean removeStudent(String studentId) {
		Set<Student> studentList=DataBaseEntry.getStudent();
		for (Iterator iterator = studentList.iterator(); iterator.hasNext();) {
			Student s = (Student) iterator.next();
			if(s.getStudentId().equalsIgnoreCase(studentId)) {
				studentList.remove(s);
				return true;
			}
		}
		return false;
	}
	public Set<TrainingProgram> getAllTrainingPrograms()
	{
		return(trainingProgramOperation.retrieveAllTrainingProgram());
	}
	public  void deleteTrainingPrograms(String id) {

		Set<TrainingProgram> tpList=DataBaseEntry.getTrainingPrograms();
		int found=0;
		for (Iterator iterator = tpList.iterator(); iterator.hasNext();) {
			TrainingProgram t = (TrainingProgram) iterator.next();

			if(t.getTrainingId().equalsIgnoreCase(id)) {
				trainingProgramOperation.deleteTrainingProgram(t);
				found=1;
			}
		}
		if(found==0)
			System.out.println("Program Not Found");


	}
	public Set<Trainer> getAllTrainersAvailable(){
		return trainerOperation.getAllTrainers();
		
	}
	public Trainer getAvailableTrainer(String trainerID) {
		return trainerOperation.getTrainerDetails(trainerID);
	}
	public Set<Center> getAllAvailableCenters(){
		return DataBaseEntry.getCenter();
	}
	public Center getValidCenter(String id) {
		Set<Center> cList=DataBaseEntry.getCenter();
		for (Iterator iterator = cList.iterator(); iterator.hasNext();) {
			Center c = (Center) iterator.next();
			if(c.getCenterId().equalsIgnoreCase(id))
			{
				return c;
			}
		}
		
		
		return null;
		
	}
	public Set<Course> getAvailableCourses(){
		return courseOperation.getAllCourse();
	}
	public Course getValidCourse(String courseID) {
		return courseOperation.getCourseDetails(courseID);
	}

}