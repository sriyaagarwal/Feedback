package com.cg.iter.feedbackmanagementsystem.service.impl;

import java.util.*;
import org.apache.log4j.*;

import com.cg.iter.feedbackmanagementsystem.dao.DataBaseEntry;
import com.cg.iter.feedbackmanagementsystem.dao.impl.TrainerManagementDaoImpl;
import com.cg.iter.feedbackmanagementsystem.exception.*;
import com.cg.iter.feedbackmanagementsystem.service.ITrainerManagement;
import com.cg.iter.feedbackmanagementsystem.service.entity.Trainer;
import com.cg.iter.feedbackmanagementsystem.validator.DataExistenceCheck;
import com.cg.iter.feedbackmanagementsystem.validator.TrainerCredentialValidation;

public class TrainerManagementImpl implements ITrainerManagement {
	private Logger logger=Logger.getLogger(TrainingProgramImpl.class);
	TrainerManagementDaoImpl tDao=new TrainerManagementDaoImpl();
	@Override
	public boolean addSkillsToTrainer(String trainerID) throws InvalidUserIdException  
	{
		if(TrainerCredentialValidation.trainerIdValidate(trainerID))
		{
			Set<Trainer> trainer;
			trainer=DataBaseEntry.getTrainer();
			Iterator value = trainer.iterator();
			boolean response=false;
			while(value.hasNext())
			{Trainer currentTrainer=(Trainer)value.next();
			if(currentTrainer.getTrainerId().equals(trainerID))
			{
				Set<String> retSkills=currentTrainer.getSkill();
				System.out.println("Hello "+currentTrainer.getTrainerName()+" you posses following skills:");

				for (String string : retSkills)  
					System.out.println(string);
				response=true;
				Scanner scanner =new Scanner(System.in);
				System.out.println("Enter number of skills you wanted to add");
				byte count;
				count=scanner.nextByte();


				System.out.println("Now enter that " +count+ " skill you want to add from the above");
				Set<String> skilllist=new HashSet<String>();
				String skill;
				for(int i=1;i<=count;i++)
				{
					skill=scanner.next();
					skilllist.add(skill.toUpperCase());
				}
				for (Iterator iterator = skilllist.iterator(); iterator.hasNext();) {
					String string = (String) iterator.next();
					
					DataExistenceCheck.DataBaseExistenceCheck(trainerID, string);
					System.out.println(string+ " is already added");
				}
				TrainerManagementDaoImpl iCrudOperation =new TrainerManagementDaoImpl();

				logger.info("Skills added are : "+skilllist);
				iCrudOperation.trainerSkillAddition(currentTrainer, skilllist);


			}
			}
			System.out.println("Skills you have after addition are:");
			value = DataBaseEntry.getTrainer().iterator();
			while(value.hasNext())
			{
				System.out.println(value.next());
			}
			return response;
		}
		else
			return false;
	}

	@Override
	public boolean delSkillsToTrainer(String trainerId) throws NoSkillInDatabaseException,SkillNotMatchedException{

		Set<Trainer> trainer;
		byte count=0;
		trainer=DataBaseEntry.getTrainer();
		Iterator value = trainer.iterator();
		boolean response=false;
		while(value.hasNext())
		{
			Trainer currentTrainer=(Trainer)value.next();
			if(currentTrainer.getTrainerId().equals(trainerId))
			{
				Set<String> retSkills=currentTrainer.getSkill();
				if(retSkills.isEmpty())
					throw new NoSkillInDatabaseException("You have no skills to delete");
				else
				{
					System.out.println("Hello "+currentTrainer.getTrainerName()+" you posses following skills:");

					for (String string : retSkills)  
						System.out.println(string);
					response=true;
					Scanner scanner =new Scanner(System.in);
					System.out.println("Enter number of skills you wanted to Delete");
					count=scanner.nextByte();
					System.out.println("Now enter that " +count+ " skill you want to delete from the above");
					Set<String> skilllist=new HashSet<String>();
					String skill;
					for(int i=1;i<=count;i++)
					{

						skill=scanner.next();

						if(!(retSkills.contains(skill.toUpperCase())))
						{
							//System.out.println("Entered skill is not there enter another");
							throw new SkillNotMatchedException("Entered skill is not there enter another");
						}
						else
							skilllist.add(skill.toUpperCase());
					}
					TrainerManagementDaoImpl iCrudOperation =new TrainerManagementDaoImpl();

					logger.info("Skills removed are : "+skilllist);
					iCrudOperation.trainerSkillDeletion(currentTrainer,skilllist);
					System.out.println("After removing..");
					retSkills=currentTrainer.getSkill();
					for (String string : retSkills)  
						System.out.println(string);
					response=true;
				}

			}

		}
		return false;
	}

	@Override
	public Trainer getTrainerDetails(String trainerID) {
		return tDao.retrieve(trainerID);
	}

	@Override
	public Set<Trainer> getAllTrainers() {
		return tDao.getAllTrainers();
	}

	@Override
	public boolean createTrainer(Trainer trainer) {
		return tDao.create(trainer);
	}


}