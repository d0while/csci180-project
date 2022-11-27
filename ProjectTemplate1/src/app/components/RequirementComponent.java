package app.components;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Requirement;
import app.repositories.RequirementRepository;

@Component
public class RequirementComponent {

	@Autowired
	private RequirementRepository requirementRepository;
	
	
	public Requirement saveNewRequirement(String title, String instruction, String type, LocalDateTime dueDate, Long studentId, Long subjectId) {
		Requirement r = new Requirement();
		r.setTitle(title);
		r.setInstruction(instruction);
		r.setType(type);
		r.setDueDate(dueDate);
		r.setStudentId(studentId);
		r.setSubjectId(subjectId);
		return requirementRepository.save(r);
	}
	public List<Requirement> listRequirements () {
		return requirementRepository.findAll();
	}
	
	public List<Requirement> findByStudentId(String studentId){
		return requirementRepository.findByStudentId(studentId);
	}	
	
	public List<Requirement> findAccomplishedByStudentId(String studentId) {
		return requirementRepository.findAccomplishedByStudentId(studentId);
	}
	
	public long countAccomplishedByStudentId(String studentId) {
		return requirementRepository.countAccomplishedByStudentId(studentId);
	}
}
