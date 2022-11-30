package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.repositories.RequirementRepository;

@Component
public class AchievementComponent {
	
	@Autowired
	private RequirementRepository requirementRepository;
	
	@Autowired
	private GradesComponent gradesComponent;

	private String makeAchievement(String title, String description) {
		return title + "\n" + description + "\n\n";
	}
	public String getMyAchievements(Long studentId) {
		String s = "YOUR ACHIEVEMENTS:\n";
		
		//Achievement for 1 completed Assignments
		if (requirementRepository.countAccomplishedByStudentId(studentId) >= 1) {
			s += makeAchievement("Beginner", "You completed a requirement.");
		}
		//Achievement for 10 completed Assignments
		if (requirementRepository.countAccomplishedByStudentId(studentId) >= 5) {
			s += makeAchievement("Apprentice", "You completed 10 requirements.");
		}
		//Achievement for 20 completed Assignments
		if (requirementRepository.countAccomplishedByStudentId(studentId) >= 20) {
			s += makeAchievement("Expert", "You completed 20 requirements.");
		}
		//Achievement for QPI > 3.35
		if (gradesComponent.calculateQpi(studentId) > 3.35) {
			s += makeAchievement("Second Honor", "Your QPI is higher than 3.35.");			
		}	
		//Achievement for QPI > 3.7
		if (gradesComponent.calculateQpi(studentId) > 3.7) {
			s += makeAchievement("First Honor", "Your QPI is higher than 3.7.");			
		}
		return s;
	}

}
