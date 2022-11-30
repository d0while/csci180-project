package app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Long>{
	
	@Query("SELECT r FROM Requirement r WHERE r.id=?1")
	Optional<Requirement> findById(Long id);

	@Query("SELECT r FROM Requirement r WHERE r.studentId=?1")
	List<Requirement> findByStudentId(Long studentId);
	
	@Query("SELECT r FROM Requirement r WHERE r.accomplished=true and r.studentId=?1")
	List<Requirement> findAccomplishedByStudentId(Long studentId);
	
	@Query("SELECT COUNT(r) FROM Requirement r WHERE r.accomplished=true")
	long countAccomplished();
	
	@Query("SELECT COUNT(r) FROM Requirement r WHERE r.accomplished=true and r.studentId=?1")
	long countAccomplishedByStudentId(Long studentId);
}
