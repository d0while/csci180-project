package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Grades;
import app.entity.Student;
import app.repositories.GradesRepository;

@Component
public class GradesComponent {
	
	@Autowired
	private GradesRepository gradesRepo;

	
	public List<Grades> listGrades(long studentId) {
		return gradesRepo.findByStudentId(studentId);
	}
	public Grades saveGrade(long studentId, long subjectId, String grade) {
		double converted = -1.0;
		System.out.println(grade);
		switch(grade) {
			case "A":
				converted = 4.0;
				break;
			case "B+":
				converted = 3.5;
				break;
			case "B":
				converted = 3.0;
				break;
			case "C+":
				converted = 2.5;
				break;
			case "C":
				converted = 2.0;
				break;
			case "D":
				converted = 1.0;
				break;
			case "F":
				converted = 0.0;
				break;
		}
		
		Grades g = new Grades();
		g.setStudentId(studentId);
		g.setSubjectId(subjectId);
		g.setGrade(converted);
		
		return gradesRepo.save(g);
	}
	public String deleteGrade(Long id) {
		gradesRepo.deleteById(id);
		return "deleted";

	}
	
	public double calculateQpi(long studentId) {
		return 4.0;
	}
	
//	public double calculateQpi(long studentId) {
//		
//	}
	
	
}

