package com.cg.iter.feedbackmanagementsystem.service.entity;

import java.util.*;

public class TrainingProgram {

	private String trainingId;
	private Date trainingStartDate;
	private Course course;
	private Trainer trainer;
	private Center center;
	public TrainingProgram(String trainingId, Date date, Course course, Trainer trainer, Center center) {
		this.trainingId=trainingId;
		this.trainingStartDate=date;
		this.course=course;
		this.trainer=trainer;
		this.center=center;
		
	}
	public Date getTrainingStartDate() {
		return trainingStartDate;
	}
	public void setTrainingStartDate(Date trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public Center getCenter() {
		return center;
	}
	public void setCenter(Center center) {
		this.center = center;
	}
	public Coordinator getCoordinator() {
		return coordinator;
	}
	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}
	@Override
	public String toString() {
		return "TrainingProgram [trainingId=" + trainingId + ", trainingStartDate=" + trainingStartDate + ", \ncourse="
				+ course.getCourseName() + ", \ntrainer=" + trainer.getTrainerName() + ", \ncenter=" + center.getCenterName() + "]";
	}
	
	
	public String getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}


	private Coordinator coordinator;


}