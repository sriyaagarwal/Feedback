package com.cg.iter.feedbackmanagementsystem.service.entity;

import java.util.HashSet;
import java.util.Set;

public class Trainer {

	/**
	 * Default constructor
	 */
	public Trainer() {
	}

	public Trainer(String trainerId, String trainerName, String trainerAddress, Set<String> skill) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		TrainerAddress = trainerAddress;
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", TrainerAddress=" + TrainerAddress
				+ ", skill=" + skill + "]\n";
	}

	/**
	 * 
	 */
	private String trainerId;

	/**
	 * 
	 */
	private String trainerName;

	/**
	 * 
	 */
	private String TrainerAddress;

	/**
	 * 
	 */
	//private Set<Skills> skills;
	private Set<String> skill;
	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerAddress() {
		return TrainerAddress;
	}

	public void setTrainerAddress(String trainerAddress) {
		TrainerAddress = trainerAddress;
	}

//	public Set<String> getSkills() {
//		Set<String> skilledSet;
//		return skilledSet;
//	}

	public void setSkills(Set<String> skills) {
		this.skill=skills;
		Set<String> skilledSet=new HashSet<String>();
		skilledSet.addAll(skills);
	}

	public Set<String> getSkill() {
		return skill;
	}

	public void setSkill(Set<String> skill) {
		this.skill = skill;
	}




}