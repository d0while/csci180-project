package app.rest.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.EventComponent;
import app.components.RequirementComponent;
import app.entity.Event;
import app.entity.Requirement;

@Component
@Path("/event")
public class EventController {
	@Autowired
	EventComponent eventComponent;

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> listEvents () {
		return eventComponent.listEvents();
	}
	
	@GET
	@Path("/listEventsByDate")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> findByDueDate(@QueryParam("dueDate") String dueDate){
		return eventComponent.findByDueDate(dueDate);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Event addEvent(
			@FormParam("title") String title,
			@FormParam("description") String description,
			@FormParam("type") String type,
			@FormParam("dueDate") String dueDate,
			@FormParam("location") String location,
			@FormParam("student_id") Long studentId
			) 
	{
		return eventComponent.saveNewEvent(title, description, type, dueDate, location, studentId);
	}
	
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEvent(@FormParam("id") Long id) {
		return eventComponent.deleteEvent(id);
	}

}
