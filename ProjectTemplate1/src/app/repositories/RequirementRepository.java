package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Long>{
	@Query("SELECT COUNT(r) FROM Requirement r WHERE r.accomplished=true")
	long countByAccomplished();
}
