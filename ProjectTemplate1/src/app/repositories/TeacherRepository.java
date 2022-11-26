package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
