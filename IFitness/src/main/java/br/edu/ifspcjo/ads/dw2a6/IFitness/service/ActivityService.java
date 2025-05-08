package br.edu.ifspcjo.ads.dw2a6.IFitness.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifspcjo.ads.dw2a6.IFitness.model.Activity;
import br.edu.ifspcjo.ads.dw2a6.IFitness.model.User;
import br.edu.ifspcjo.ads.dw2a6.IFitness.repository.ActivityRepository;
import br.edu.ifspcjo.ads.dw2a6.IFitness.repository.UserRepository;
import br.edu.ifspcjo.ads.dw2a6.IFitness.service.exception.NonExistentOrInactiveUserException;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Activity save(Activity activity) {
		Optional<User> user = userRepository.findById(activity.getUser().getId());
		if(!user.isPresent() || !user.get().getActive()) {
			throw new NonExistentOrInactiveUserException();
		}
		return activityRepository.save(activity);
	}

	public Activity update(Long id, Activity activity) {
		Optional<User> user = userRepository.findById(activity.getUser().getId());
		if(!user.isPresent() || !user.get().getActive()) {
			throw new NonExistentOrInactiveUserException();
		}

		Activity activitySaved = findActivityById(id);
		BeanUtils.copyProperties(activity, activitySaved, "id");
		return activityRepository.save(activitySaved);
	}
	
	public Activity findActivityById(Long id) {
		Activity activitySaved = activityRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return activitySaved;
	}
}