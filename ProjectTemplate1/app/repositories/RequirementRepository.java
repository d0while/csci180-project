package app.repositories;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import app.entity.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Long>{

}
