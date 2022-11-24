package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
		
	@Query("SELECT s FROM Student s WHERE s.name = ?1")
	public List<Student> findByName(String nameQuery);
}
