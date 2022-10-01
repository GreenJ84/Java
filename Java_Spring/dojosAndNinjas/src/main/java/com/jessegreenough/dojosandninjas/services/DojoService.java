package com.jessegreenough.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jessegreenough.dojosandninjas.models.Dojo;
import com.jessegreenough.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;

	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> chosenDojo = dojoRepo.findById(id);
		if (chosenDojo.isPresent()) {
			return chosenDojo.get();
		}
		return null;
	}
	
	public Dojo save(Dojo d) {
		return dojoRepo.save(d);
	}
	
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}
