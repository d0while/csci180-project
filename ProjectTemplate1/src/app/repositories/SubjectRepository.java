package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

	List<Subject> findByStudentId(long studentId);

}
