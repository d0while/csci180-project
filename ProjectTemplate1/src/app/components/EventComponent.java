package app.components;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

import javax.ws.rs.QueryParam;
import app.entity.Event;
import app.entity.Requirement;
import app.repositories.EventRepository;


@Component
public class EventComponent {
	
	@Autowired
	private EventRepository eventRepository;
	
	public Event saveNewEvent(String title, String description, String type, String dueDate, String location, Long studentId) {
		Event e = new Event();
		e.setTitle(title);
		e.setDescription(description);
		e.setType(type);
		e.setDueDate(dueDate);
		e.setLocation(location);
		e.setStudent_id(studentId);
		return eventRepository.save(e);
	}
	
	public String deleteEvent(Long id) {
		eventRepository.deleteById(id);
		return "Event with id: [" + id + "] deleted";
	}
	
	public List<Event> listEvents() {
		return eventRepository.findAll();
	}
	
	public Event findById(Long id) {
		return eventRepository.findById(id).orElse(null);
	}
	
	public List<Event> findByStudentId(Long studentId){
		return eventRepository.findByStudentId(studentId);
	}
	
	public List<Event> findByDueDate(String dueDate){
		return eventRepository.findByDueDate(dueDate);
	}
	
	
	

}
