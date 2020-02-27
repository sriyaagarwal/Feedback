package com.cg.iter.feedbackmanagementsystem.service;
import java.util.*;

import com.cg.iter.feedbackmanagementsystem.exception.InvalidUserIdException;
import com.cg.iter.feedbackmanagementsystem.exception.NoSkillInDatabaseException;
import com.cg.iter.feedbackmanagementsystem.exception.SkillNotMatchedException;
import com.cg.iter.feedbackmanagementsystem.service.entity.Trainer;

/**
 * 
 */
public interface ITrainerManagement {

	/**
	 * @throws InvalidUserIdException 
	 * 
	 */
	public boolean addSkillsToTrainer( String trainerId) throws InvalidUserIdException, InvalidUserIdException;

	/**
	 * 
	 */
	public Set<Trainer> getAllTrainers();

	/**
	 * 
	 */
	public boolean createTrainer(Trainer trainer);

	Trainer getTrainerDetails(String trainerID);

	boolean delSkillsToTrainer(String trainerId) throws NoSkillInDatabaseException, SkillNotMatchedException;

}