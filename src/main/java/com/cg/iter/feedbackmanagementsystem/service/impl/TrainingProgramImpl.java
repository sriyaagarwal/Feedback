package com.cg.iter.feedbackmanagementsystem.service.impl;

import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.dao.impl.*;
import com.cg.iter.feedbackmanagementsystem.service.ITrainingProgramOperation;
import com.cg.iter.feedbackmanagementsystem.service.entity.TrainingProgram;

public class TrainingProgramImpl implements ITrainingProgramOperation{

	TrainingProgramDaoImpl tDao=new TrainingProgramDaoImpl();
	@Override
	public boolean createProgram(TrainingProgram tr) {
		return (tDao.create(tr));
	}

	@Override
	public boolean deleteTrainingProgram(TrainingProgram tr) {
		return (tDao.delete(tr));
	}

	@Override
	public boolean modifyTrainingProgram(TrainingProgram tr) {
		return (tDao.update(tr));
	}


	@Override
	public Set retrieveAllTrainingProgram() {
		return(tDao.retrieveAll());
	}
	@Override
	public TrainingProgram retrieve(String id) {
		return(tDao.retrieve(id));
		
	}


}
