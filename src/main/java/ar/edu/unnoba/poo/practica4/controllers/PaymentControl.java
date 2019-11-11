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
import ar.edu.unnoba.poo.practica4.services.PaymentService;

import ar.edu.unnoba.poo.practica4.entities.Payment;

@RestController
public class PaymentControl {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/payments")
	public List<Payment> retrieveAllPayments() {
		return paymentService.retrieveAllPayments();
	}
	
	@PostMapping("/payments")
	public void addPayment(@RequestBody Payment payment) {
		paymentService.addPayment(payment);
	}
	
	@GetMapping("/payments/{id}")
	public Payment getPayment(@PathVariable Long id) {
	    return paymentService.getPayment(id);
	}
	
	@PutMapping("/payments/{id}")
	public Payment replaceUser(@RequestBody Payment payment, @PathVariable Long id) {
	    return paymentService.replacePayment(payment, id);
	}

	  @DeleteMapping("/payments/{id}")
	  void deletePayment(@PathVariable Long id) {
		  paymentService.deletePayment(id);
	  }
}
