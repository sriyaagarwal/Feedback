package com.cg.iter.feedbackmanagementsystem.validator;

import java.util.Iterator;
import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.dao.DataBaseEntry;
import com.cg.iter.feedbackmanagementsystem.enumvariables.Skills;
import com.cg.iter.feedbackmanagementsystem.service.entity.Course;
import com.cg.iter.feedbackmanagementsystem.service.entity.Trainer;

public class DataExistenceCheck {
	public static boolean DataExistenceCheck(String courseId) {
		boolean result=false;
		Set<Course> course=DataBaseEntry.course;
		Iterator value = course.iterator();
		while(value.hasNext()) {
			Course courses = (Course)value.next();
			if(courses.getCourseId().equalsIgnoreCase(courseId)) {
				String cId=courses.getCourseId();
				//System.out.println(courses.getCourseId());
				//System.out.println(cId);
				result=true;

			}
		}

		return result;
	}
	public static boolean DataBaseExistenceCheck(String trainerId,String skill)
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
				//				Set<String> retSkills=tt.getSkill();
				for(Skills skillEnum: Skills.values())
				{
					if(skillEnum.name().equalsIgnoreCase(skill))
					{response=true;
					break;
					}
				}
				break;
			}
		}
		return response;
	}
}
