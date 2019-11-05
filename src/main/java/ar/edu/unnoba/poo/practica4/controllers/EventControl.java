package ar.edu.unnoba.poo.practica4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import ar.edu.unnoba.poo.practica4.services.EventService;

import ar.edu.unnoba.poo.practica4.entities.Event;

@RestController
public class EventControl {

    @Autowired
    private EventService EventService;

    @GetMapping("/events")
	public List<Event> retrieveAllEvents() {
		return eventService.retrieveAllEvents();
    }
    
    @PostMapping("/events")
	public void addEvent(@RequestBody Event event) {
		eventService.addEvent(event);
    }
    
    @GetMapping("/events/{id}")
	public Event getEvent(@PathVariable Long id) {
	    return eventService.getEvent(id);
    }
    
    @PutMapping("/events/{id}")
	public Event replaceEvent(@RequestBody Event event, @PathVariable Long id) {
        return eventService.replaceEvent(event, id);
    }
    
    @DeleteMapping("/events/{id}")
    void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}