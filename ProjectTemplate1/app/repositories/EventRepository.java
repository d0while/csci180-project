package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
