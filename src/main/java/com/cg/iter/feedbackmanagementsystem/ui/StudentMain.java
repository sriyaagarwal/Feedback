package com.cg.iter.feedbackmanagementsystem.ui;

import java.util.Scanner;
import org.apache.log4j.*;

import com.cg.iter.feedbackmanagementsystem.exception.*;


public class StudentMain {
	private static Logger log=Logger.getLogger(StudentMain.class);
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		log.info("Started");
		while(true) {
			System.out.println("===========WELCOME TO FEEDBACK MANAGEMENT SYSTEM============");
			System.out.println("------------------------------------------------------------");
			System.out.println("ENTER YOUR CHOICE");
			System.out.println("1. Admin ");
			System.out.println("2. Student");
			System.out.println("3. Coordinator");
			System.out.println("4. Exit");
			int choice = input.nextInt();
			switch(choice) {
			case 1:
				adminselect();
				break;
			case 2:
				studentSelect();
				break;
			case 3:
				coordinatorSelect();
				break;
			case 4:
				System.exit(0);
				log.info("Exiting System...");
				break;
			default:
				System.out.println("Wrong choice");
				break;

			}
		}
	}

	private static void coordinatorSelect() {
		Scanner input = new Scanner(System.in);
		System.out.println("===========WELCOME TO COORDINATOR CONTROLLER================");
		System.out.println("------------------------------------------------------------");
		System.out.println("ENTER YOUR CHOICE");
		System.out.println("1. Create Program "); 
		System.out.println("2. Delete Program ");
		System.out.println("3. Get All Programs");
		System.out.println("4. Get Program Details");
		System.out.println("5. Update Training Program");
		System.out.println("6. Add Student");
		System.out.println("7. Update Student Details");
		System.out.println("8. Remove Student");
		System.out.println("9. Get All Students Details");
		System.out.println("10. Add Course");
		System.out.println("11. Delete Course");
		System.out.println("12. Update Course");
		System.out.println("13. Get All Course Details");
		System.out.println("14. View Defaulter List");
		System.out.println("15. View Feedback Report");
		int choice=input.nextInt();
		switch(choice) {
		case 1:
			CoordinatorController.createProgram();
			break;
		case 2:
			CoordinatorController.deleteProgram();
			break;
		case 3:
			CoordinatorController.getAllRunningPrograms();
			break;
		case 4:
			CoordinatorController.getProgramDetails();
			break;
		case 5:
			CoordinatorController.UpdateTrainingProgram();
			break;
		case 6:
			CoordinatorController.addStudent();
			break;
		case 7:
			CoordinatorController.modifyStudent();
			break;
		case 8:
			CoordinatorController.removeStudent();
			break;
		case 9:
			CoordinatorController.getAllStudentDetails();
			break;
		case 10:
			try {
				CoordinatorController.addCourse();
			} catch (InvalidCourseIdException | InvalidCourseNameException | CourseNullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 11:
			try {
				CoordinatorController.deleteCourse();
			} catch (InvalidCourseNameException | InvalidCourseIdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 12:
			try {
				CoordinatorController.modifyCourse();
			} catch (InvalidCourseNameException | InvalidCourseIdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 13:
			CoordinatorController.getAllCourse();
			break;
		case 14:
			CoordinatorController.viewdefaultlistController();
			break;
		case 15:
			CoordinatorController.viewFeedbackReportController();
			break;
		}
	}

	private static void studentSelect() {
		Scanner input = new Scanner(System.in);
		System.out.println("===========WELCOME TO STUDENT CONTROLLER======================");
		System.out.println("------------------------------------------------------------");
		System.out.println("ENTER YOUR CHOICE");
		System.out.println("1. Add Feedback ");
		int choice = input.nextInt();
		switch(choice) {
		case 1:
			try {
				StudentController.givefeedbackController();
			} catch (InvalidIdException e) {
				e.printStackTrace();
			}
		default:
			break;			
		}
	}

	private static void adminselect() {
		Scanner input = new Scanner(System.in);
		System.out.println("===========WELCOME TO ADMIN CONTROLLER======================");
		System.out.println("------------------------------------------------------------");
		System.out.println("ENTER YOUR CHOICE");
		System.out.println("1. Add Skill to Trainer ");
		System.out.println("2. Delete skill of trainer");
		System.out.println("3. View Defaulter List");
		System.out.println("4. View FeedbackReport");
		int choice = input.nextInt();
		String id;
		switch(choice) {
		case 1:
			try {
				AdminController.addSkillControllers();
			} catch (InvalidUserIdException e) {
				e.printStackTrace();
			}

			break;
		case 2:
			try {
				AdminController.delSkillController();
			} catch (InvalidUserIdException | NoSkillInDatabaseException | SkillNotMatchedException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			AdminController.viewDefaultList();
			break;
		case 4:
			AdminController.viewReport();
			break;
		default:
			break;			
		}
	}
}