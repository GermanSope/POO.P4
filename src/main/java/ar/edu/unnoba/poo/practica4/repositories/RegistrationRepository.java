package ar.edu.unnoba.poo.practica4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unnoba.poo.practica4.entities.Registration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    @Query("select r from Registration r where r.id = :id")
	public Registration findRegistrationById(@Param("id") long id);
}