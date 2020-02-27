package com.cg.iter.feedbackmanagementsystem.validator;

import javax.naming.InvalidNameException;

import com.cg.iter.feedbackmanagementsystem.exception.InvalidIdException;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidInputException;

	public class UserDetailsValidator   {
	public UserDetailsValidator() {
		
}
	public boolean validStudentName(String Name) {
		
		boolean flag=false;
		try {
		if((Name.matches("[A-Z][a-z]*" ))) {
			return true;
		}else {
			throw new InvalidIdException();
		}
		}
		catch(InvalidIdException excep){
			excep.getMessage();
		}
		return flag;
	}
	public static  boolean validStudentId(String studentId) throws InvalidIdException {
		boolean flag=false;
		try {
		if((studentId.matches("ST_[0-9]{4}"))) {
			return true;
		}else {
			throw new InvalidIdException();
		}
		}
		catch(InvalidIdException excep){
			excep.getMessage();
		}
		return flag;
		
	}
	
	public boolean isCriteriaValid(int criteria) throws InvalidInputException {
	
		if (criteria>=1 & criteria<=5)
			return true;
		
		else {
			throw new InvalidInputException("The input entered is not valid");
			}
	
		
	}


}
