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
import br.edu.ifspcjo.ads.dw2a6.TIF.Model.OrdemServiço;
import br.edu.ifspcjo.ads.dw2a6.TIF.repository.ClientRepository;
import br.edu.ifspcjo.ads.dw2a6.TIF.repository.OrdemServiçoRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Ordens")
public class OrdemServiçoResources {

	@Autowired
	private OrdemServiçoRepository ordemServiçoRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<OrdemServiço> list(){
		return ordemServiçoRepository.findAll();
	}
	
	@PostMapping
	public OrdemServiço create(@Valid @RequestBody OrdemServiço ordemServiço, HttpServletResponse response) {
		
		Client client = clientRepository.findById(ordemServiço.getClient().getId())
	            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
		
		ordemServiço.setClient(client);
		
		return ordemServiçoRepository.save(ordemServiço);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemServiço> findById(@PathVariable Long id){
		Optional<OrdemServiço> ordemServiço = ordemServiçoRepository.findById(id);
		if(ordemServiço.isPresent()) {
			return ResponseEntity.ok(ordemServiço.get());
		}
		return ResponseEntity.notFound().build();
	}
}
