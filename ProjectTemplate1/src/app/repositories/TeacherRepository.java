package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	@Query("SELECT s FROM TEACHER s WHERE s.name = ?1")
	public List<Teacher> findByName(String nameQuery);
}
