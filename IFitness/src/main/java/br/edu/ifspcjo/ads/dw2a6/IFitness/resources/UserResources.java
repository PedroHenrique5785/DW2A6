package br.edu.ifspcjo.ads.dw2a6.IFitness.resources;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifspcjo.ads.dw2a6.IFitness.model.User;
import br.edu.ifspcjo.ads.dw2a6.IFitness.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserResources {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> list(){
		return userRepository.findAll();
	}
	
	@PostMapping
	public User create(@Valid @RequestBody User user, HttpServletResponse response) {
		return userRepository.save(user);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.notFound().build();
	}
}
