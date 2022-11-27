package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Long>{

}
