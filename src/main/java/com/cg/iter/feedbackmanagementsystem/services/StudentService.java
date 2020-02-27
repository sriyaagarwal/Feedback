
package com.cg.iter.feedbackmanagementsystem.services;

import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.dao.IFetchAll;
import com.cg.iter.feedbackmanagementsystem.dao.impl.FetchStudentImpl;
import com.cg.iter.feedbackmanagementsystem.service.entity.Student;

public class StudentService {

	public StudentService() {
	}

	public boolean givefeedback (String studentId) {

		IFetchAll<Student> fetch = new FetchStudentImpl();
		Set<Student> studentss = fetch.retrieveAll();
		Student studentobjct;

		boolean flag = false;
		for (Student student : studentss) {

			if (student.getStudentId().equals(studentId)) {
			
				studentobjct= student;
				flag = true;
				break;
			}
		}
		return flag;

	}
}