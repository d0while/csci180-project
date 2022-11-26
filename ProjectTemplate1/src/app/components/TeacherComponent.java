package app.components;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Teacher;
import app.repositories.TeacherRepository;

@Component
public class TeacherComponent {
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@PostConstruct
	public void init()
	{
		if (teacherRepo.count()==0)
		{
			Teacher t = addTeacher("Paula Bianca Pineda", "pbp@gmail.com", "Wednesday and Friday, 11:00am-8:00pm" );
			teacherRepo.save(t);
			
			t = addTeacher("Leanne Ena Trinidad", "let@gmail.com", "Monday and Friday, 11:00am-8:00pm" );
			teacherRepo.save(t);
			
			t = addTeacher("Felizia Tiburcio", "ft@gmail.com", "Wednesday, 9:00am-5:00pm" );
			teacherRepo.save(t);
			
			t = addTeacher("Aedin Clay", "ac@gmail.com", "Tuesday and Thursday, 11:00am-8:00pm" );
			teacherRepo.save(t);
			
			t = addTeacher("Haze Bugayong", "hb@gmail.com", "Monday, 9:00am-5:00pm" );
			teacherRepo.save(t);
			
			t = addTeacher("Lance Andrei Tan", "lat@gmail.com", "Monday and Wednesday, 11:00am-8:00pm" );
			teacherRepo.save(t);
		}
	}

	
	public List<Teacher> listTeachers() {
		return teacherRepo.findAll();
	}
	
	public Teacher addTeacher(String name, String email, String consultation_hours) {
		Teacher t = new Teacher();
		t.setName(name);
		t.setEmail(email);
		t.setConsultation_hours(consultation_hours);
		return teacherRepo.save(t);
	}
	
	public String deleteTeacher(Long id) {
		teacherRepo.deleteById(id);
		return "Teacher with id " + id + " successfully deleted";

	}
}