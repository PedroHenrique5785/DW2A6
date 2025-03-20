package br.edu.ifspcjo.ads.dw2a6.IFitness.resources;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifspcjo.ads.dw2a6.IFitness.Model.Gender;
import br.edu.ifspcjo.ads.dw2a6.IFitness.Model.User;

@RestController
public class UserResources {

	@GetMapping("/users")
	public List<User> list(){
		User user1 = new User();
		user1.setId(1L);
		user1.setName("Pedro");
		user1.setEmail("chaves.pedro@");
		user1.setPassword("1234");
		user1.setBirthday(LocalDate.of(2003, 3, 22));
		user1.setGender(Gender.MASCULINO);
		
		User user2 = new User();
		user2.setId(1L);
		user2.setName("Pedro");
		user2.setEmail("chaves.pedro@");
		user2.setPassword("1234");
		user2.setBirthday(LocalDate.of(2003, 3, 22));
		user2.setGender(Gender.MASCULINO);
		
		return Arrays.asList(user1, user2);
	}
}
