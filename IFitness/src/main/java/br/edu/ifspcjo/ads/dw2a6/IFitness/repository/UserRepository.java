package br.edu.ifspcjo.ads.dw2a6.IFitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifspcjo.ads.dw2a6.IFitness.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
