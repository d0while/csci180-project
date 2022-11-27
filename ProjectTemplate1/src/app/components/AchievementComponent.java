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
			makeAchievement("Beginner", "You completed a requirement.");
		}
		//Achievement for 10 completed Assignments
		if (requirementRepository.countAccomplishedByStudentId(studentId) >= 5) {
			makeAchievement("Apprentice", "You completed 10 requirements.");
		}
		//Achievement for 20 completed Assignments
		if (requirementRepository.countAccomplishedByStudentId(studentId) >= 20) {
			makeAchievement("Expert", "You completed 20 requirements.");
		}
		//Achievement for QPI > 3.35
		if (gradesComponent.calculateQpi(studentId) > 3.35) {
			makeAchievement("Smart", "Your QPI is higher than 3.35.");			
		}	
		return s;
	}

}
