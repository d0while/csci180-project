package app.components;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Subject;
import app.repositories.SubjectRepository;

@Component
public class SubjectComponent {
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@PostConstruct
	public void init()
	{
		if (subjectRepo.count()==0)
		{
			Subject s = addSubject("CSCI 70", "Wednesday, 9:00am-12:00pm", Long.valueOf(1), 3, Long.valueOf(1));
			subjectRepo.save(s);
			
			s = addSubject("CSCI 60", "Monday and Thursday, 5:00pm-6:30pm", Long.valueOf(2), 3, Long.valueOf(1));
			subjectRepo.save(s);
			
			s = addSubject("ISCS 30.38", "Thurday, 9:00am-10:00am", Long.valueOf(3), 1, Long.valueOf(1));
			subjectRepo.save(s);
			
			s = addSubject("SocSci 14", "Thursday, 3:00pm-6:00pm", Long.valueOf(4), 3, Long.valueOf(2));
			subjectRepo.save(s);
			
			s = addSubject("Practicum", "Monday to Wednesday, 1:00pm-5:00pm", Long.valueOf(5), 1, Long.valueOf(2));
			subjectRepo.save(s);
			
			s = addSubject("Thesis Writing 199.2", "Saturday, 9:00am-12:00pm", Long.valueOf(6), 1, Long.valueOf(2));
			subjectRepo.save(s);
		}
	}
	
	public List<Subject> listSubjects() {
		return subjectRepo.findAll();
	}
	
	public List<Subject> listSubjectsById(long studentId) {
		return subjectRepo.findByStudentId(studentId);
	}
	
	
	public Subject addSubject(String title, String schedule, Long teacherId, int units, Long studentId) {
		Subject s = new Subject();
		s.setTitle(title);
		s.setSchedule(schedule);
		s.setTeacherId(teacherId);
		s.setUnits(units);
		s.setStudentId(studentId);;
		return subjectRepo.save(s);
	}
	
	public String deleteSubject(Long id) {
		subjectRepo.deleteById(id);
		return "Subject with id " + id + " successfully deleted";

	}
}