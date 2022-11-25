package app.rest.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.EventComponent;
import app.components.EventDto;
import app.entity.Event;

@Component
@Path("/event")
public class EventController {
    @Autowired
    EventComponent eventComponent;

    @GET
    @Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Event> listEvents()
    {
        return eventComponent.listEvents();
    }
	
    @POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
    public Event addEvent(EventDto dto)
    {
        return eventComponent.saveEvent(dto);
    }

    
}
