package br.edu.ifspcjo.ads.dw2a6.TIF.resources;


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

import br.edu.ifspcjo.ads.dw2a6.TIF.Model.Client;
import br.edu.ifspcjo.ads.dw2a6.TIF.repository.ClientRepository;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/clients")
public class ClientResources {

	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<Client> list(){
		return clientRepository.findAll();
	}
	
	@PostMapping
	public Client create(@RequestBody Client client, HttpServletResponse response) {
		return clientRepository.save(client);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id){
		Optional<Client> client = clientRepository.findById(id);
		if(client.isPresent()) {
			return ResponseEntity.ok(client.get());
		}
		return ResponseEntity.notFound().build();
	}
}
