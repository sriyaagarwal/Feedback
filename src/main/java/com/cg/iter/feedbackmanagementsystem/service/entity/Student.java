package com.cg.iter.feedbackmanagementsystem.service.entity;

public class Student {
	private String studentId;
	private String studentName;

	public Student(String studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public int hashCode() {
		return this.getStudentId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.getStudentId().equals(((Student)obj).getStudentId());
	}
	@Override
	public String toString() {
		return "\nStudentId:"+ studentId + " studentName:" + studentName +"";
	}

}
