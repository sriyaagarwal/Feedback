package com.cg.iter.feedbackmanagementsystem.dao.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.dao.DataBaseEntry;
import com.cg.iter.feedbackmanagementsystem.dao.ICrudOperation;
import com.cg.iter.feedbackmanagementsystem.service.entity.Course;
import com.cg.iter.feedbackmanagementsystem.service.entity.Feedback;
import com.cg.iter.feedbackmanagementsystem.service.entity.Student;
import com.cg.iter.feedbackmanagementsystem.service.entity.Trainer;
import com.cg.iter.feedbackmanagementsystem.service.entity.TrainingProgram;

/**
 * 
 */
public class TrainerManagementDaoImpl implements ICrudOperation<Trainer> {
public static Set<String> skilltest;
public static Set<String> skilldel;

	@Override
	public boolean create(Trainer trainer) {
		return DataBaseEntry.getTrainer().add(trainer);
	}

	@Override
	public boolean update(Trainer o) {
		
		Set<Trainer> trainerList=DataBaseEntry.getTrainer();
		for (Iterator iterator = trainerList.iterator(); iterator.hasNext();) {
			Trainer trainer = (Trainer) iterator.next();
			if(trainer.getTrainerId().equalsIgnoreCase(o.getTrainerId()))
			{
				trainerList.remove(trainer);
				trainerList.add(trainer);
				return true;
			}
		}
		return false;
	}
	@Override
	public Trainer retrieve(String id) {
		
		Set<Trainer> trainerList=DataBaseEntry.getTrainer();
		for (Iterator iterator = trainerList.iterator(); iterator.hasNext();) {
			Trainer trainer = (Trainer) iterator.next();
			if(trainer.getTrainerId().equalsIgnoreCase(id))
				return trainer;
		}
		return null;
	}

	public boolean delete(Trainer o) {
		
		Set<Trainer> trainerList=DataBaseEntry.getTrainer();
		for (Iterator iterator = trainerList.iterator(); iterator.hasNext();) {
			Trainer trainer = (Trainer) iterator.next();
			if(trainer.getTrainerId().equalsIgnoreCase(o.getTrainerId()))
			{
				trainerList.remove(trainer);
				return true;
			}
		}
		return false;
	}

	public Set<Trainer> getAllTrainers() {
		return DataBaseEntry.getTrainer();
	}

	public void trainerSkillDeletion(Trainer trainer, Set<String> skilllist) {
	
		Set<String> updatedSkill=trainer.getSkill();
		updatedSkill.removeAll(skilllist);
//		if(updatedSkill.isEmpty())
//			System.out.println("No Database for deletion of skills");
		System.out.println(trainer.getTrainerName()+" your skills after deletion operation are as listed below:");
		if(updatedSkill.isEmpty())
			System.out.println("Now you have no skills added in database");
		

		for (String s : updatedSkill)  
			System.out.println(s);
		System.out.println("Deletion operation done Successfully");
		//skilldel=updatedSkill;
		
	}
	public void trainerSkillAddition(Trainer trainer,Set<String> skilllist)
	{
		Set<String> updatedSkill=trainer.getSkill();
		System.out.println(updatedSkill);
		updatedSkill.addAll(skilllist);
		System.out.println(trainer.getTrainerName()+" your skills after Addition operation are as listed below:");
		for (String s : updatedSkill)  
			System.out.println(s);
		skilltest=updatedSkill;
		System.out.println("Addition operation done Successfully");
	}

	@Override
	public Set<Trainer> retrieveAll() {
		return DataBaseEntry.getTrainer();
	}


}