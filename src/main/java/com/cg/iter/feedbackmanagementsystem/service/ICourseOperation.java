package com.cg.iter.feedbackmanagementsystem.service;

import java.util.*;

import com.cg.iter.feedbackmanagementsystem.exception.CourseNullException;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidCourseIdException;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidCourseNameException;
import com.cg.iter.feedbackmanagementsystem.service.entity.Course;


public interface ICourseOperation {


	public Set<Course> getAllCourse();


	


	boolean deleteCourse(Course course) throws InvalidCourseIdException, InvalidCourseNameException;





	boolean modifyCourse(Course course) throws InvalidCourseIdException, InvalidCourseNameException;





	boolean addCourse(Course course) throws InvalidCourseIdException, InvalidCourseNameException;

}