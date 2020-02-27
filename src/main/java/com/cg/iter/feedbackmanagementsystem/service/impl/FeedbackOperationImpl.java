package com.cg.iter.feedbackmanagementsystem.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.dao.*;
import com.cg.iter.feedbackmanagementsystem.dao.impl.*;
import com.cg.iter.feedbackmanagementsystem.service.*;
import com.cg.iter.feedbackmanagementsystem.service.entity.Feedback;
import com.cg.iter.feedbackmanagementsystem.service.entity.Student;
import com.cg.iter.feedbackmanagementsystem.service.entity.TrainingProgram;

public class FeedbackOperationImpl implements IFeedbackOperation {

	@Override
	public Set<Student> viewDefaulterList() {
		IFetchAll<Student> studentoperation = new FetchStudentImpl();
		Set<Student> student = studentoperation.retrieveAll();
		ICrudOperation<Feedback> feedbackoperation = new FeedbackDaoImpl();

		Set<Feedback> feedbacks = feedbackoperation.retrieveAll();

		Set<Student> defaultlist = new HashSet<>();
		defaultlist.addAll(student);
		for (Feedback f : feedbacks) {
			if (student.contains(f.getStudent())) 
			{
				defaultlist.remove(f.getStudent());
			} 
		}
	
		
		return defaultlist;

	}

	@Override
	public Set<Feedback> viewFeedbackReport() {
		// TODO Auto-generated method stub
		ICrudOperation<Feedback> iCrudOperation = new FeedbackDaoImpl();
		Set<Feedback> feedbackset = iCrudOperation.retrieveAll();
		return feedbackset;
	}

	@Override
	public void addFeedback(Student student,TrainingProgram trainingProgramAdd, int criteria1, int criteria2, int criteria3, int criteria4, int criteria5) {
		FeedbackDaoImpl fDao=new FeedbackDaoImpl();
		fDao.addFeedback(student,trainingProgramAdd,criteria1,criteria2,criteria3,criteria4,criteria5);
		
	}

}
















