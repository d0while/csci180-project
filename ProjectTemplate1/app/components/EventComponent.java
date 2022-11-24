package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Event;
import app.repositories.EventRepository;

@Component
public class EventComponent 
{
    @Autowired
    private EventRepository eventRepo;

    public Event saveEvent(EventDto dto)
    {
        Event e = new Event();
        e.setName(dto.getName());
        e.setDescription(dto.getDescription());
        e.setDate(dto.getDate());
        e.setLocation(dto.getLocation());
        return eventRepo.save(e);
    }

    public List<Event> listEvents()
    {
        return eventRepo.findAll();
    }

    public String deleteRequirement(Long id)
    {
        try
		{
			eventRepo.deleteById(id);
			return "Event with id: [" + id + "] deleted";
		}
		catch(Exception e)
		{
			return "Error deleting event";
		}
    }
}
