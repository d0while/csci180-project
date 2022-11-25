package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Teacher;
import app.repositories.TeacherRepository;

@Component
public class TeacherComponent {
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	public Teacher saveTeacher(TeacherDto dto) {
		Teacher s = new Teacher();
		s.setName(dto.getName());
		s.setEmail(dto.getEmail());
		return teacherRepo.save(s);
	}
	
	public String deleteTeacher(Long id) {
		try
		{
			teacherRepo.deleteById(id);
			return "Teacher with id: [" + id + "] deleted";
		}
		catch(Exception e)
		{
			return "Error deleting Teacher";
		}
	}
	
	public List<Teacher> listTeachers() {
		return teacherRepo.findAll();
	}
	
	public List<Teacher> findByName(String nameQuery) {
		return teacherRepo.findByName(nameQuery);
	}
}
