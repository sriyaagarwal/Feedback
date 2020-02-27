package com.cg.iter.feedbackmanagementsystem.ui;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.cg.iter.feedbackmanagementsystem.dao.DataBaseEntry;
import com.cg.iter.feedbackmanagementsystem.exception.*;
import com.cg.iter.feedbackmanagementsystem.service.*;
import com.cg.iter.feedbackmanagementsystem.service.entity.Course;
import com.cg.iter.feedbackmanagementsystem.service.entity.Feedback;
import com.cg.iter.feedbackmanagementsystem.service.entity.Trainer;
import com.cg.iter.feedbackmanagementsystem.service.impl.TrainerManagementImpl;
import com.cg.iter.feedbackmanagementsystem.services.AdminServices;
import com.cg.iter.feedbackmanagementsystem.validator.TrainerCredentialValidation;

/**
 * 
 */
public class AdminController {
	private static Logger logger=Logger.getLogger(AdminController.class);
	AdminServices adminService=new AdminServices();
	public static void viewDefaultList() 
	{
		AdminServices.viewdefaultlist();
	}
	public static void viewReport() 
	{
		AdminServices.viewReport();
	}
	
	
	public static void delSkillController() throws InvalidUserIdException,NoSkillInDatabaseException,SkillNotMatchedException
	{
		Scanner scanner=new Scanner(System.in);
		ITrainerManagement itrainermanagement;
		//boolean check=false;
		System.out.println("Enter the Trainer Id:");
		String trainerId=scanner.next();
		if(TrainerCredentialValidation.trainerIdValidate(trainerId) && TrainerCredentialValidation.trainerRegistrationCheck(trainerId))
		{
			Set<Trainer> trainer;
			trainer=DataBaseEntry.getTrainer();
			Iterator value = trainer.iterator();

			while(value.hasNext())
			{
				Trainer tt=(Trainer)value.next();

				if((tt.getTrainerId()).equals(trainerId))
				{
					System.out.println(tt.getTrainerName());
					itrainermanagement=	new TrainerManagementImpl();
					logger.info("Deleted trainer skills : "+trainerId);
					itrainermanagement.delSkillsToTrainer(trainerId);
					//check=true;
				}

			}


		}
		else
		{
			throw new InvalidUserIdException("Entered id is not registered");
		}



	}
	public static void addSkillControllers() throws InvalidUserIdException 
	{

		Scanner scanner=new Scanner(System.in);
		System.out.println("Before adding trainer");
		
		Set<Trainer> trList=DataBaseEntry.getTrainer();
		for (Iterator iterator = trList.iterator(); iterator.hasNext();) {
			Trainer trainer = (Trainer) iterator.next();
			System.out.println(trainer);
		}
		
		System.out.println("Enter the Trainer Id:");
		String trainerId=scanner.next();

		if(TrainerCredentialValidation.trainerIdValidate(trainerId))
		{
			AdminServices.addSkillToTrainer(trainerId);

			logger.info("Added trainer skills : "+trainerId);
		}
		else
		{
			throw new InvalidUserIdException("Entered ID is not in valid format");
		}
	}
	public static void getListOfTrainers() 
	{
		System.out.println(DataBaseEntry.infoTrainers());

	}
	public static void getTrainerDetails() 
	{
		//System.out.println(DataBaseEntry.infoTrainers());
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter trainer Id");
		String tId=sc.nextLine();
		for (Iterator iterator = DataBaseEntry.infoTrainers().iterator(); iterator.hasNext();) {
			Trainer t = (Trainer) iterator.next();
			//System.out.println(type);
			if(t.getTrainerId().equals(tId)) 
			{
				System.out.println(t);
				return;
			}
		}
		System.out.println("Trainer Not Found");

	}
	public static void createTrainer() {

		Set<Trainer> trainer=DataBaseEntry.getTrainer();
		Set<String> skills=new HashSet<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ID");
		String id=sc.next();
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter location");
		String location=sc.next();
		char ch = 'y';
		do {
			System.out.println("Enter skill");
			String skill=sc.next();
			skills.add(skill);
			System.out.println("Do you want to add more skills?(y/n)");
			ch=sc.next().charAt(0);
		}while(ch=='y') ;
		AdminServices.createTrainer(new Trainer(id, name, location, skills));

	}

}