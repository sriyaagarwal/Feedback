package com.cg.iter.feedbackmanagementsystem.service.entity;

import java.util.Set;

public class Course {
	private String courseId;
	private String courseName;
	private String courseDesc;
	private int courseCharges;
	public Course(String courseId, String courseName, String courseDesc, int courseCharges) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDesc = courseDesc;
		this.courseCharges = courseCharges;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	public int getCourseCharges() {
		return courseCharges;
	}
	public void setCourseCharges(int courseCharges) {
		this.courseCharges = courseCharges;
	}
	@Override
	public String toString() {
		return " \nCourse added is: " + " CourseId: " + courseId + " , CourseName: " + courseName + " , CourseDesc: " + courseDesc
				+ " , CourseCharges:" + courseCharges + "";
	}

	

	



}