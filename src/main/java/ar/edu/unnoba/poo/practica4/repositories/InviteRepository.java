package ar.edu.unnoba.poo.practica4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unnoba.poo.practica4.entities.Invite;

public interface InviteRepository extends JpaRepository<Invite, Long> {
}