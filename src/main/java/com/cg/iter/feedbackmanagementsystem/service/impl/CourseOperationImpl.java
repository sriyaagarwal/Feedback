package com.cg.iter.feedbackmanagementsystem.service.impl;
import java.util.*;

import com.cg.iter.feedbackmanagementsystem.dao.DataBaseEntry;
import com.cg.iter.feedbackmanagementsystem.dao.ICrudOperation;
import com.cg.iter.feedbackmanagementsystem.dao.impl.CourseOperationDaoImpl;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidCourseIdException;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidCourseNameException;
import com.cg.iter.feedbackmanagementsystem.service.ICourseOperation;
import com.cg.iter.feedbackmanagementsystem.service.entity.Course;
import com.cg.iter.feedbackmanagementsystem.validator.*;
//import com.cg.trainingmanagementystem.services.CoordinatorService;
public  class CourseOperationImpl implements ICourseOperation {
	CourseOperationDaoImpl cDao=new CourseOperationDaoImpl();
	@Override
	public boolean addCourse(Course course) throws InvalidCourseIdException, InvalidCourseNameException {
		return cDao.create(course);
	}
	@Override
	public boolean deleteCourse(Course course) throws InvalidCourseIdException, InvalidCourseNameException {
		if(DataExistenceCheck.DataExistenceCheck(course.getCourseId())) {
			return cDao.delete(course);
		}
		return false;

	}
	@Override
	public boolean modifyCourse(Course course) throws InvalidCourseIdException, InvalidCourseNameException {
		if(DataExistenceCheck.DataExistenceCheck(course.getCourseId())) {
			return cDao.update(course);
		
		} 
		return false;


	}
	public Course getCourseDetails(String courseid) {
		
		Set<Course> courses=cDao.retrieveAll();
		for (Iterator iterator = courses.iterator(); iterator.hasNext();) {
			Course c = (Course) iterator.next();
			if(c.getCourseId().equals(courseid)){
				return c;
			}
			
		}
		return null;
	}
	@Override
	public Set<Course> getAllCourse() {

		return DataBaseEntry.infoDb();

	}

}