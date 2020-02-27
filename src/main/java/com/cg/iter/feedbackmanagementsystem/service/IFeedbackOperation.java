package com.cg.iter.feedbackmanagementsystem.service;

import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.service.entity.Feedback;
import com.cg.iter.feedbackmanagementsystem.service.entity.Student;
import com.cg.iter.feedbackmanagementsystem.service.entity.TrainingProgram;

public interface IFeedbackOperation {
	public Set<Feedback> viewFeedbackReport();

	public Set<Student> viewDefaulterList();

	void addFeedback(Student student, TrainingProgram trainingProgramAdd, int criteria1, int criteria2, int criteria3,
			int criteria4, int criteria5);


}