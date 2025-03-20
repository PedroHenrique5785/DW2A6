package br.edu.ifspcjo.ads.dw2a6.IFitness.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Teste {
	
	@GetMapping("/test")
	public String teste()
	{
		return "Hello Word";
	}
}
