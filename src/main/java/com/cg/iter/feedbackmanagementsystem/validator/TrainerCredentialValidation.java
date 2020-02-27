package com.cg.iter.feedbackmanagementsystem.validator;

import java.util.Iterator;
import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.dao.DataBaseEntry;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidUserIdException;
import com.cg.iter.feedbackmanagementsystem.service.entity.Trainer;

public class TrainerCredentialValidation 
{
	public static boolean trainerIdValidate(String trainerId) throws InvalidUserIdException
	{
		if(trainerId.matches("TR[0-9]{6}"))
		{
			return true;
		}
		else if(trainerId.matches("[$&+,:;=?@#|'<>.-^*()%!]*")) 
		{
			throw new InvalidUserIdException("Entered Id is not in proper format");
		}
		else
		{
			throw new InvalidUserIdException("Trainer is not authorized");
		}

	}
	public static boolean trainerRegistrationCheck(String trainerId)
	{
		Set<Trainer> trainer;
		trainer=DataBaseEntry.getTrainer();
		Iterator value = trainer.iterator();
		boolean response=false;
		while(value.hasNext())
		{
			Trainer tt=(Trainer)value.next();
			if(tt.getTrainerId().equalsIgnoreCase(trainerId))
			{

				response=true;
				break;
			}
		}
		return response;
	}
}



