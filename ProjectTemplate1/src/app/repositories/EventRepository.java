package app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Event;


public interface EventRepository extends JpaRepository<Event, Long>{
	
	@Query("SELECT e FROM Event e WHERE e.id=?1")
	Optional<Event> findById(Long id);
	
	@Query("SELECT e FROM Event e WHERE e.student_id=?1")
	List<Event> findByStudentId(Long studentId);
//	
//	@Query("SELECT e FROM Event e WHERE e.dueDate=?1")
//	public List<Event> findDueDateBetween(Long dueDate);
//
	public List<Event> findByDueDate(String dueDate);
	

}
