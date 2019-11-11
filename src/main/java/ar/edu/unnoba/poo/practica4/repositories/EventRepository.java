package ar.edu.unnoba.poo.practica4.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unnoba.poo.practica4.entities.Event;
import ar.edu.unnoba.poo.practica4.entities.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select e from Event e where e.id = :id")
    public Event findEventById(@Param("id") long id);
    
    @Query("select e from Event e where e.owner = :owner")
    public List<Event> findAllEventByOwnerID(@Param("owner") User owner);
}