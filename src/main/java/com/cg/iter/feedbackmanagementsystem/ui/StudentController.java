package com.cg.iter.feedbackmanagementsystem.ui;

import java.util.*;

import org.apache.log4j.Logger;

import com.cg.iter.feedbackmanagementsystem.dao.DataBaseEntry;
import com.cg.iter.feedbackmanagementsystem.exception.*;
import com.cg.iter.feedbackmanagementsystem.service.entity.*;
import com.cg.iter.feedbackmanagementsystem.service.impl.FeedbackOperationImpl;
import com.cg.iter.feedbackmanagementsystem.services.StudentService;
import com.cg.iter.feedbackmanagementsystem.validator.UserDetailsValidator;

public class StudentController {

	private Student student;
	private TrainingProgram trainingProgram;
	private static Logger logger=Logger.getLogger(StudentController.class);
	public static void givefeedbackController() throws InvalidIdException {
		String idd=null;

		StudentService objct= new StudentService();

		Scanner input = new Scanner(System.in);
		FeedbackOperationImpl f=new FeedbackOperationImpl();
//		System.out.println("List of Students");
//		System.out.println(DataBaseEntry.getStudent());
		System.out.println("enter student id");
		try {
			idd = input.next();

		} catch (Exception exception) {
			System.out.println("The id entered is not valid");
			System.out.println(exception.getMessage());
		}




		if (UserDetailsValidator.validStudentId(idd)) 
		{

			UserDetailsValidator detailsValidator=new UserDetailsValidator();

			System.out.println("Now you are eligible to give feedback ");
			try {

				Set<TrainingProgram> trainingPrograms = DataBaseEntry.getTrainingProgram();
				System.out.println("List of Training Programs");
				for (Iterator iterator = trainingPrograms.iterator(); iterator.hasNext();) 
				{
					TrainingProgram t= (TrainingProgram) iterator.next();
					System.out.println(t.getTrainingId());
				}
				System.out.println("Enter Training Program ID");
				String tpID=input.next();
			
				TrainingProgram trainingProgramAdd=null;
				for (Iterator iterator = trainingPrograms.iterator(); iterator.hasNext();) 
				{
					TrainingProgram t= (TrainingProgram) iterator.next();
					if(t.getTrainingId().equalsIgnoreCase(tpID)) 
					{
						System.out.println("Training Program Found");
						trainingProgramAdd=t;
						logger.info("Adding Feedback of "+idd+" for training program "+tpID);

					}
				}
				System.out.println("Did you like this program(1-5)");
				int criteria1 = input.nextInt();
				detailsValidator.isCriteriaValid(criteria1);
				System.out.println("Was  the concept explained by teacher was clear(1-5)");
				int criteria2 = input.nextInt();
				detailsValidator.isCriteriaValid(criteria2);
				System.out.println("Was the assignments assigned to you was enough for understanding(1-5)");
				int criteria3 = input.nextInt();
				detailsValidator.isCriteriaValid(criteria3);
				System.out.println("Is the assigned time is enough for your understanding (1-5)");
				int criteria4 = input.nextInt();
				detailsValidator.isCriteriaValid(criteria4);
				System.out.println("were the system were working properly(1-5)");
				int criteria5 = input.nextInt();
				detailsValidator.isCriteriaValid(criteria5);




				Student studentFeedbackAdd = null;
				Set<Student> studentsList=DataBaseEntry.getStudent();
				for (Iterator iterator = studentsList.iterator(); iterator.hasNext();) {
					Student s = (Student) iterator.next();
					if(s.getStudentId().equalsIgnoreCase(idd))
					{
						studentFeedbackAdd=s;
					}
				}

				if(trainingProgramAdd==null) {
					System.out.println("TrainingProgram Not Found...Unable to Add");
				}
				else 
				{
					f.addFeedback(studentFeedbackAdd,trainingProgramAdd,criteria1,criteria2,criteria3,criteria4,criteria5);
				}

			}
			catch(Exception exception) 
			{
				System.out.println(exception.getMessage());
			}
		}

		else {
			System.out.println("Your ID is not in the database...please validate it");
		}

	}

}