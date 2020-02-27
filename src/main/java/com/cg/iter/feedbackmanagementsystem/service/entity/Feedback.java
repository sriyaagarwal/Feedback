package com.cg.iter.feedbackmanagementsystem.service.entity;

public class Feedback {
	//private Participant participant;
	private TrainingProgram trainingProgram;
	private int criteriaFirst;
	private int criteriaSecond;
	private int criteriaThird;
	private int criteriaFourth;
	private int criteriaFifth;

	public Feedback(Student student, TrainingProgram trainingProgram, int criteriaFirst, int criteriaSecond,
			int criteriaThird, int criteriaFourth, int criteriaFifth) {
		super();
		this.student = student;
		this.trainingProgram = trainingProgram;
		this.criteriaFirst = criteriaFirst;
		this.criteriaSecond = criteriaSecond;
		this.criteriaThird = criteriaThird;
		this.criteriaFourth = criteriaFourth;
		this.criteriaFifth = criteriaFifth;
	}
	

	@Override
	public String toString() {
		return "Feedback [\ntrainingProgram=" + trainingProgram.getTrainingId() + "\ncriteriaFirst=" + criteriaFirst + ", criteriaSecond="
				+ criteriaSecond + ", criteriaThird=" + criteriaThird + ", criteriaFourth=" + criteriaFourth
				+ ", criteriaFifth=" + criteriaFifth + "\nstudent=" + student.getStudentName() + "]";
	}


	private Student student;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public TrainingProgram getTrainingProgram() {
		return trainingProgram;
	}
	public void setTrainingProgram(TrainingProgram trainingProgram) {
		this.trainingProgram = trainingProgram;
	}
	public int getCriteriaFirst() {
		return criteriaFirst;
	}
	public void setCriteriaFirst(int criteriaFirst) {
		this.criteriaFirst = criteriaFirst;
	}
	public int getCriteriaSecond() {
		return criteriaSecond;
	}
	public void setCriteriaSecond(int criteriaSecond) {
		this.criteriaSecond = criteriaSecond;
	}
	public int getCriteriaThird() {
		return criteriaThird;
	}
	public void setCriteriaThird(int criteriaThird) {
		this.criteriaThird = criteriaThird;
	}
	public int getCriteriaFourth() {
		return criteriaFourth;
	}
	public void setCriteriaFourth(int criteriaFourth) {
		this.criteriaFourth = criteriaFourth;
	}
	public int getCriteriaFifth() {
		return criteriaFifth;
	}
	public void setCriteriaFifth(int criteriaFifth) {
		this.criteriaFifth = criteriaFifth;
	}

	
}
