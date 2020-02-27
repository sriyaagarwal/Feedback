package com.cg.iter.feedbackmanagementsystem.validator;

import java.util.Set;
import java.util.regex.Pattern;

import com.cg.iter.feedbackmanagementsystem.exception.CourseNameNullException;
import com.cg.iter.feedbackmanagementsystem.exception.CourseNullException;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidCourseIdException;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidCourseNameException;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidIdException;
import com.cg.iter.feedbackmanagementsystem.service.entity.Course;

public class UserInputValidator {
	

	public static String courseNameValid(String courseName) {
		boolean flag=false;
		try {
			String regex="[A-Za-z]{1,30}";
			if((courseName.matches(regex))) {
				return courseName;
			}
			else {
				throw new InvalidCourseNameException();
		}
		}
			catch(InvalidCourseNameException e) {
				e.getMessage();
			}
		return courseName ;
		
	}
	public static String courseIdNotEmpty(String courseId) {
		
		try {
			if(courseId!=null ) {
				return courseId;
			}
			else {
				throw new CourseNullException();
		}
		}
		
		catch(CourseNullException e) {
			e.getMessage();
		}
		return courseId;
	}
	
public static String courseNameNotEmpty(String courseName) throws CourseNameNullException{
	try {
		if(courseName!=null ) {
			return courseName;
		}
		else {
			throw new CourseNullException();
	}
	}
	
	catch(CourseNullException e) {
		e.getMessage();
	}
	return courseName;
}


public boolean deleteCourse(Set<Course> course) throws InvalidCourseIdException, InvalidCourseNameException {
	// TODO Auto-generated method stub
	return false;
}






}