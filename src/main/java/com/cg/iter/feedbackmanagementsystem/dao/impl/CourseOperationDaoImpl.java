package com.cg.iter.feedbackmanagementsystem.dao.impl;
import java.util.*;

import com.cg.iter.feedbackmanagementsystem.dao.DataBaseEntry;
import com.cg.iter.feedbackmanagementsystem.dao.ICrudOperation;
import com.cg.iter.feedbackmanagementsystem.exception.*;
import com.cg.iter.feedbackmanagementsystem.service.entity.Course;
import com.cg.iter.feedbackmanagementsystem.validator.UserInputValidator;
public  class CourseOperationDaoImpl  implements ICrudOperation<Course>  {


	@Override
	public boolean create(Course course) {
		if(course==null) {
			try {
				throw new CourseNullException();
			} catch (CourseNullException e) 
			{
				e.printStackTrace();
			}
		}
		String value = course.getCourseId();
		DataBaseEntry.getCourse().add(course);
		return true;
	}
	@Override
	public boolean update(Course course)  {
		Set<Course> cList=DataBaseEntry.getCourse();
		for (Iterator iterator = cList.iterator(); iterator.hasNext();) {
			Course c = (Course) iterator.next();
			if(c.getCourseId().equalsIgnoreCase(course.getCourseId()))
			{
				cList.remove(c);
				cList.add(course);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Course course) {

		String deletedCourseId= course.getCourseId();
		if(course.getCourseId().contentEquals(deletedCourseId))
		{
			DataBaseEntry.getCourse().remove(course);
			return true;
		}

		return false;


	}
	@Override
	public Set<Course> retrieveAll() {
		return DataBaseEntry.getCourse();
	}
	@Override
	public Course retrieve(String s) {
		Set<Course> cList=DataBaseEntry.getCourse();
		for (Iterator iterator = cList.iterator(); iterator.hasNext();) {
			Course course = (Course) iterator.next();
			if(course.getCourseId().equalsIgnoreCase(s)) {
				return course;
			}
		}
		return null;
	}

}