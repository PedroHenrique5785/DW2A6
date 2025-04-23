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

import br.edu.ifspcjo.ads.dw2a6.IFitness.model.Activity;
import br.edu.ifspcjo.ads.dw2a6.IFitness.repository.ActivityRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/activities")
public class ActivityResource {

	@Autowired
	private ActivityRepository activityRepository;
	
	@GetMapping
	public List<Activity> list(){
		return activityRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Activity> findById(@PathVariable Long id) {
		Optional<Activity> activity = activityRepository.findById(id);
		if(activity.isPresent()) {
			return ResponseEntity.ok(activity.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public Activity create(@Valid @RequestBody Activity activity) {
		return activityRepository.save(activity);
	}
}