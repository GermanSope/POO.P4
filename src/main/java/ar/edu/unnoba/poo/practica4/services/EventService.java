package ar.edu.unnoba.poo.practica4.services;

import java.util.List;

import ar.edu.unnoba.poo.practica4.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import ar.edu.unnoba.poo.practica4.entities.Event;

@Service
public class EventService {

    @Autowired
    private EventRepository EventRepository;
    
    public List<Event> retrieveAllEvents() {
		return EventRepository.findAll();
    }
    
    public void addEvent(Event event) {
	    EventRepository.save(event);
	}