package ar.edu.unnoba.poo.practica4.services;

import java.util.List;

import ar.edu.unnoba.poo.practica4.repositories.InviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import ar.edu.unnoba.poo.practica4.entities.Invite;

@Service
public class InviteService {
    @Autowired
    private InviteRepository inviteRepository;
    
    public List<Invite> retrieveInvite() {
		return inviteRepository.findAll();
    }
    
    public void addInvite(Invite invite) {
	    inviteRepository.save(invite);
    }
    
    public Invite getInvite(Long id) {
	    return inviteRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }
    
    
    public void deleteInvite(@PathVariable Long id) {
		inviteRepository.deleteById(id);
    }
    
    public Invite findInviteById (Long id) {
		return inviteRepository.findInviteById (id);
	}
}