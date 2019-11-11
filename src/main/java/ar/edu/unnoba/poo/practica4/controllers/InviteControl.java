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
import ar.edu.unnoba.poo.practica4.services.InviteService;

import ar.edu.unnoba.poo.practica4.entities.Invite;

@RestController
public class InviteControl {

	@Autowired
	private InviteService inviteService;
	
	@GetMapping("/invites")
	public List<Invite> retrieveAllInvites() {
		return inviteService.retrieveAllInvites();
	}
	
	@PostMapping("/invites")
	public void addInvite(@RequestBody Invite invite) {
		inviteService.addInvite(invite);
	}
	
	@GetMapping("/invites/{id}")
	public Invite getInvite(@PathVariable Long id) {
	    return inviteService.getInvite(id);
	}
	
	@PutMapping("/invites/{id}")
	public Invite replaceInvite(@RequestBody Invite invite, @PathVariable Long id) {
	    return inviteService.replaceInvite(invite, id);
	}

	  @DeleteMapping("/invites/{id}")
	  void deleteInvite(@PathVariable Long id) {
		  inviteService.deleteInvite(id);
	  }
}
