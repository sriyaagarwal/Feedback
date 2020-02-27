package com.cg.iter.feedbackmanagementsystem.dao;
import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.exception.EmptyFeedbackException;

public interface ICrudOperation<T> {

	/**
	 * @throws EmptyFeedbackException 
	 * 
	 */
	public boolean create(T object) throws EmptyFeedbackException;
	public boolean update(T object);	
	public T retrieve(String s);

	public boolean delete(T object);

	Set<T> retrieveAll();




}