package com.cg.iter.feedbackmanagementsystem.dao.impl; 
import java.util.*;

import com.cg.iter.feedbackmanagementsystem.dao.DataBaseEntry;
import com.cg.iter.feedbackmanagementsystem.dao.ICrudOperation;
import com.cg.iter.feedbackmanagementsystem.service.entity.TrainingProgram;

/**
 * 
 */
public class TrainingProgramDaoImpl implements ICrudOperation<TrainingProgram> {

	@Override
	public boolean create(TrainingProgram o) {
		return DataBaseEntry.getTrainingPrograms().add(o);
	}

	@Override
	public boolean update(TrainingProgram o) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean delete(TrainingProgram o) {
		Set<TrainingProgram> tpList=DataBaseEntry.getTrainingProgram();
		TrainingProgram delTP=null;
		for (Iterator iterator = tpList.iterator(); iterator.hasNext();) {
			TrainingProgram trainingProgram = (TrainingProgram) iterator.next();
			if(o.getTrainingId().equalsIgnoreCase(trainingProgram.getTrainingId()))
				delTP=trainingProgram;
		}
		return (tpList.remove(delTP));
	}

	@Override
	public Set<TrainingProgram> retrieveAll() {
		return DataBaseEntry.getTrainingPrograms();
	}

	@Override
	public TrainingProgram retrieve(String s) {
		Set<TrainingProgram> tpList=DataBaseEntry.getTrainingProgram();
		for (Iterator iterator = tpList.iterator(); iterator.hasNext();) {
			TrainingProgram t = (TrainingProgram) iterator.next();
			if(t.getTrainingId().equalsIgnoreCase(s)) {
				return t;
			}
		}
		return null;
	}

//	@Override
//	public Set<TrainingProgram> retrieveAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}


}