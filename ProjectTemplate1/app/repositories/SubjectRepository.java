package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
