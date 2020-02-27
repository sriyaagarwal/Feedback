package com.cg.iter.feedbackmanagementsystem.dao.impl;

import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.dao.DataBaseEntry;
import com.cg.iter.feedbackmanagementsystem.dao.IFetchAll;
import com.cg.iter.feedbackmanagementsystem.service.entity.Feedback;
import com.cg.iter.feedbackmanagementsystem.service.entity.Student;


public class FetchStudentImpl implements IFetchAll<Student>{
	@Override
	public  Set<Student> retrieveAll(){
		Set<Student> student=DataBaseEntry.infoOfStudent();
		return student;

	}
	public  Set<Feedback> retrieve(){
		Set<Feedback> feedback=DataBaseEntry.infoOfFeedback();
		return feedback;
	}

}