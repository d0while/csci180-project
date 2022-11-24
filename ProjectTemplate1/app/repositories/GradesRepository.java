package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Grades;

public interface GradesRepository extends JpaRepository<Grades, Long>{

}
