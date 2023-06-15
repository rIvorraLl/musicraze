package com.musicraze;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.musicraze.domain.User;

import com.musicraze.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return userRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
		User savedUser = userRepository.save(user);
		return ResponseEntity.created(new URI("/api/users" + savedUser.getId())).body(savedUser);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		User currentUser = userRepository.findById(id).orElseThrow(RuntimeException::new);
		currentUser.setName(user.getName());
		currentUser.setEmail(user.getEmail());
		currentUser.setPassword(user.getPassword());
		currentUser = userRepository.save(user);
		return ResponseEntity.ok(currentUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
