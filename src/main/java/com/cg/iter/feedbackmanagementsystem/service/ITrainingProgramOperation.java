package com.cg.iter.feedbackmanagementsystem.service;

import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.service.entity.Program;
import com.cg.iter.feedbackmanagementsystem.service.entity.TrainingProgram;

public interface ITrainingProgramOperation {
	
	Set retrieveAllTrainingProgram();
	TrainingProgram retrieve(String id);
	boolean modifyTrainingProgram(TrainingProgram tr);
	boolean createProgram(TrainingProgram tr);
	boolean deleteTrainingProgram(TrainingProgram tr);
}
