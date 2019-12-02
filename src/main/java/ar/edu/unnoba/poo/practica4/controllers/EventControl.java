package ar.edu.unnoba.poo.practica4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import ar.edu.unnoba.poo.practica4.services.EventService;
import ar.edu.unnoba.poo.practica4.services.UserService;
import ar.edu.unnoba.poo.practica4.entities.Event;
import ar.edu.unnoba.poo.practica4.entities.User;

import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("events")
@RestController
public class EventControl {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "events";
	}
	
	@GetMapping(path = "{id}")
	public List<Event> findAllEventByOwnerID(@RequestParam(value="owner") @PathVariable Long userID){
		return eventService.findAllEventByOwnerID(userID);
	}

	@GetMapping
	public List<Event> retrieveAllEvents(){
		return eventService.retrieveAllEvents();
	}
	
	
	@PostMapping
	public void addUser(@RequestBody Event event) {
		User u = userService.getUser(event.getOwner().getId());
		event.setOwner(u);
		eventService.addEvent(event);
	}

	@DeleteMapping(path = "{id}")
	void deleteEvent(@PathVariable Long id) {
		eventService.deleteEvent(id);
	}
	
}
