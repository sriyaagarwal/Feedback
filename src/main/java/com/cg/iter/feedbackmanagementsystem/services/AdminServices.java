
package com.cg.iter.feedbackmanagementsystem.services;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.exception.InvalidUserIdException;
import com.cg.iter.feedbackmanagementsystem.service.ICourseOperation;
import com.cg.iter.feedbackmanagementsystem.service.IFeedbackOperation;
import com.cg.iter.feedbackmanagementsystem.service.ITrainerManagement;
import com.cg.iter.feedbackmanagementsystem.service.entity.Course;
import com.cg.iter.feedbackmanagementsystem.service.entity.Feedback;
import com.cg.iter.feedbackmanagementsystem.service.entity.Student;
import com.cg.iter.feedbackmanagementsystem.service.entity.Trainer;
import com.cg.iter.feedbackmanagementsystem.service.impl.FeedbackOperationImpl;
import com.cg.iter.feedbackmanagementsystem.service.impl.TrainerManagementImpl;
import com.cg.iter.feedbackmanagementsystem.validator.DataExistenceCheck;

public class AdminServices {

	static TrainerManagementImpl itrainermanagement=new TrainerManagementImpl();
	public static void addSkillToTrainer(String trainerId) throws InvalidUserIdException
	{	
		if(itrainermanagement.addSkillsToTrainer(trainerId))
			System.out.println("Skill is successfully added");
		else
			System.out.println("Trainer is not Registered");
	}
	public static void delSkillToTrainer(String trainerId) throws InvalidUserIdException
	{	
		
	}
	
	public static void createTrainer(Trainer trainer2) {
		itrainermanagement.createTrainer(trainer2);
	}
	public static void viewdefaultlist() {

		//List<String> viewDefaulterList = new ArrayList<String>();
		// List<String>list=new ArrayList<String>();
		FeedbackOperationImpl obj = new FeedbackOperationImpl();

		Set<Student> list = obj.viewDefaulterList();
		// System.out.println(obj.viewDefaulterList());
		//list.addAll(obj.viewDefaulterList());

		System.out.println("the defaulter students are:" + list);

	}

	public static void viewReport() {

		FeedbackOperationImpl objct=new FeedbackOperationImpl();

		Set<Feedback> set=new HashSet<Feedback>();
		set=objct.viewFeedbackReport();
		for(Feedback feed:set) {
			System.out.println(feed);

		}

	}


}