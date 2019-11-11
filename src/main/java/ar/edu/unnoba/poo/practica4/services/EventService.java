package ar.edu.unnoba.poo.practica4.services;

import java.util.List;

import ar.edu.unnoba.poo.practica4.repositories.EventRepository;
import ar.edu.unnoba.poo.practica4.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import ar.edu.unnoba.poo.practica4.entities.Event;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    
    public List<Event> retrieveAllEvents() {
		  return eventRepository.findAll();
    }
    
    public void addEvent(Event event) {
	    eventRepository.save(event);
    }

   public Event getEvent(Long id) {
    return eventRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
   }

   public Event replaceEvent(Event event, Long id) {
     return eventRepository.findById(id)
     .map(e -> {
      e.setEventDate(event.getEventDate());
      e.setStartRegistrations(event.getStartRegistrations());
      e.setEndRegistrations(event.getEndRegistrations());
      e.setCapacity(event.getCapacity());
      e.setCost(event.getCost());
      e.setPrivateEvent(event.isPrivateEvent());
      return eventRepository.save(e);
     })
     .orElseGet(() -> {
       return eventRepository.save(event);
     });
   }

    public void deleteEvent(@PathVariable Long id) {
      eventRepository.deleteById(id);
    }
     
    public Event findEventById(long id) {
      return eventRepository.findEventById(id);
    }
}