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

import br.edu.ifspcjo.ads.dw2a6.TIF.Model.FormaPagamento;
import br.edu.ifspcjo.ads.dw2a6.TIF.Model.OrdemServiço;
import br.edu.ifspcjo.ads.dw2a6.TIF.repository.FormaPagamentoRepository;
import br.edu.ifspcjo.ads.dw2a6.TIF.repository.OrdemServiçoRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pagamentos")
public class FormaPagamentoResources {
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private OrdemServiçoRepository ordemServiçoRepository;
	
	@GetMapping
	public List<FormaPagamento> list(){
		return formaPagamentoRepository.findAll();
	}
	
	@PostMapping
	public FormaPagamento create(@Valid @RequestBody FormaPagamento formaPagamento, HttpServletResponse response) {
			
		OrdemServiço ordemServiço = ordemServiçoRepository.findById(formaPagamento.getOrdemServiço().getId())
				.orElseThrow(() -> new RuntimeException("Ordem de pagamento não encontrada"));
		
		formaPagamento.setOrdemServiço(ordemServiço);
		
		return formaPagamentoRepository.save(formaPagamento);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FormaPagamento> findById(@PathVariable Long id){
		Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(id);
		if(formaPagamento.isPresent()) {
			return ResponseEntity.ok(formaPagamento.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
}
