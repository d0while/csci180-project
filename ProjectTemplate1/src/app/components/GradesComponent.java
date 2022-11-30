package app.components;

import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Grades;
import app.entity.Student;
import app.entity.Subject;
import app.repositories.GradesRepository;
import app.repositories.StudentRepository;
import app.repositories.SubjectRepository;

@Component
public class GradesComponent {

	
	@Autowired
	private GradesRepository gradesRepo;
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Autowired
	private StudentRepository studentRepo;

	
	public String listGrades(long studentId) {
		String message = "";
				
		Student student = studentRepo.findById(studentId);
		List<Grades> grades = gradesRepo.findByStudentId(studentId);
		
		message += student.getName() + "\'s grades\n";
		
		for (Grades grade : grades ) {
			long subjectId = grade.getSubjectId();
			Subject subject = subjectRepo.findById(subjectId);
			message += subject.getTitle() + " - " + grade.getLetterGrade();
			message += "\n";
		
		}
		return message;

		}
				
		
		
		
	
	public String saveGrade(long studentId, long subjectId, String grade) {
		
	// check if subject is being taken by student first 
		String message = "";
		boolean flag = false;
		
		Student student = studentRepo.findById(studentId);
		String studentName = student.getName();
		
		List<Subject> subjects = subjectRepo.findByStudentId(studentId);
		
		Subject subject = null;
		String subjectName = "";
		
		for (Subject s : subjects) {
			if (subjectId == s.getId()) { // found subject!
				flag = true;
				subject = subjectRepo.findById(subjectId);
				subjectName = subject.getTitle();
				break;
			}
		}
		
		// if student is taking subject
		if (flag == true) {	
			
			double converted = -1.0;
			
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
			
			// if grade already exists, edit entry
			Grades temp = gradesRepo.findByStudentIdAndSubjectId(studentId, subjectId);
			if (temp != null) {
				
				temp.setGrade(converted);
				temp.setLetterGrade(grade);
				gradesRepo.save(temp);
				
				message = "Edited grade to " + grade + " for " + studentName + " in " + subjectName;

				
			} else {
				
				Grades g = new Grades();
				g.setStudentId(studentId);
				g.setSubjectId(subjectId);
				g.setLetterGrade(grade);
				g.setGrade(converted);
				
				gradesRepo.save(g);
				message = "Added grade " + grade + " for " + studentName + " in " + subjectName;

				
			}
			

			
		} else {
			message = studentName + " isn't taking this subject!";
		}
		
				
		return message;
	}
	public String deleteGrade(Long id) {
		gradesRepo.deleteById(id);
		return "deleted";

	}
	
	public double calculateQpi(long studentId) {
		
		double totalRawScore = 0.0;
		int totalUnits = 0;
		
		// get student's grades
		List <Grades> grades = gradesRepo.findByStudentId(studentId);
		if (grades.size() == 0) {
			return 0;
		}
		for (Grades grade : grades) {
			long subjectId = grade.getSubjectId();
			
			Subject subject = subjectRepo.findById(subjectId);
			
			double rawScore = grade.getGrade();
			int units = subject.getUnits();
			
			totalRawScore += rawScore * units;			
			totalUnits += units;
			
		}
		
		double qpi = totalRawScore / totalUnits;
		
		double roundedQpi = BigDecimal.valueOf(qpi)
				    .setScale(2, RoundingMode.HALF_UP)
				    .doubleValue();
		
		return roundedQpi;
	}
	

	
}

