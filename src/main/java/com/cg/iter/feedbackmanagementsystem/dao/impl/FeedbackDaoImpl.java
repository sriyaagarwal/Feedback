package com.cg.iter.feedbackmanagementsystem.dao.impl;
import java.util.*;

import com.cg.iter.feedbackmanagementsystem.dao.DataBaseEntry;
import com.cg.iter.feedbackmanagementsystem.dao.ICrudOperation;
import com.cg.iter.feedbackmanagementsystem.exception.EmptyFeedbackException;
import com.cg.iter.feedbackmanagementsystem.service.IFeedbackOperation;
import com.cg.iter.feedbackmanagementsystem.service.entity.Course;
import com.cg.iter.feedbackmanagementsystem.service.entity.Feedback;
import com.cg.iter.feedbackmanagementsystem.service.entity.Student;
import com.cg.iter.feedbackmanagementsystem.service.entity.TrainingProgram;

/**
 * 
 */
public class FeedbackDaoImpl implements ICrudOperation<Feedback> {

	@Override
	public boolean create(Feedback feedback) throws EmptyFeedbackException {
		return false;
		
	}

	@Override
	public boolean update(Feedback feedback) {
		return true;
		
	}

	@Override
	public boolean delete(Feedback feedback) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Set<Feedback> retrieveAll() {
		Set<Feedback> feedback=DataBaseEntry.infoOfFeedback();
		return feedback;
	}

	
	public boolean addFeedback(Student student, TrainingProgram trainingProgramAdd, int criteria1, int criteria2,
			int criteria3, int criteria4, int criteria5) {

		if(DataBaseEntry.getFeedback().add(new Feedback(student, trainingProgramAdd, criteria1, criteria2, criteria3, criteria4, criteria5))) {
			System.out.println("Feedback Succesfully Entered");
			return true;
		}
		return false;
	}

	@Override
	public Feedback retrieve(String s) {
		
		return null;
	}
}

