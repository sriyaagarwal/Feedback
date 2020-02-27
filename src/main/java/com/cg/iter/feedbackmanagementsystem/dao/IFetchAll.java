package com.cg.iter.feedbackmanagementsystem.dao;

import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.service.entity.Feedback;

public interface IFetchAll<T> {
public Set<T> retrieveAll();
public Set<Feedback> retrieve();

}