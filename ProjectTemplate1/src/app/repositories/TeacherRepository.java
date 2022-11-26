package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	List<Teacher> findByStudentId(long studentId);
}
