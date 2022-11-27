package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Student;
import app.repositories.StudentRepository;

@Component
public class StudentComponent {
	
	@Autowired
	private StudentRepository studentRepo;
	
	public Student saveStudent(String name, String email) {
		Student s = new Student();
		s.setName(name);
		s.setEmail(email);
		return studentRepo.save(s);
	}
	
	public String deleteStudent(Long id) {
		studentRepo.deleteById(id);
		return "Student with id: [" + id + "] deleted";
	}
	
	public List<Student> listStudents() {
		return studentRepo.findAll();
	}
	
	public List<Student> findByName(String nameQuery) {
		return studentRepo.findByName(nameQuery);
	}
}
