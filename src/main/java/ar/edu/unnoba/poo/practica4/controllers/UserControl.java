package ar.edu.unnoba.poo.practica4.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import ar.edu.unnoba.poo.practica4.services.UserService;

import ar.edu.unnoba.poo.practica4.entities.User;
import ar.edu.unnoba.poo.practica4.repositories.UserRepository;

@Controller
public class UserControl {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userService.retrieveAllUsers();
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@GetMapping("/users/adduser")
	public String adduser(User user){
		return "adduser";
	}

	@PostMapping("/users/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "adduser";
        }
        user.setRole("USER");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "home";
    }
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
	    return userService.getUser(id);
	}
	
	@PutMapping("/users/{id}")
	public User replaceUser(@RequestBody User user, @PathVariable Long id) {
	    return userService.replaceUser(user, id);
	}

	@DeleteMapping("/users/{id}")
	 void deleteUser(@PathVariable Long id) {
	  userService.deleteUser(id);
	  }
}
