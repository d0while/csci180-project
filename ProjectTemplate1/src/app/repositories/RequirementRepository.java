package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Long>{
	
	
	@Query("SELECT r FROM Requirement r WHERE r.studentId=?1")
	long listRequirementsByStudent(String studentId);
	
	@Query("SELECT r FROM Requirement r WHERE r.accomplished=true and r.studentId=?1")
	long listAccomplishedByStudent(String studentId);
	
	@Query("SELECT COUNT(r) FROM Requirement r WHERE r.accomplished=true")
	long countByAccomplished();
	
	@Query("SELECT COUNT(r) FROM Requirement r WHERE r.accomplished=true and r.studentId=?1")
	long countByAccomplishedByStudent(String studentId);
}
