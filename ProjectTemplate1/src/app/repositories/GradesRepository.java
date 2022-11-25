package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import app.entity.Grades;

public interface GradesRepository extends JpaRepository<Grades, Long>{

	public List<Grades> findByStudentId(long studentId);
	

}
