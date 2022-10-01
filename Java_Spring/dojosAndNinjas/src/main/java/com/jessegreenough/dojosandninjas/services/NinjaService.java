package com.jessegreenough.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jessegreenough.dojosandninjas.models.Ninja;
import com.jessegreenough.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Ninja> getAllNinjas(){
		return ninjaRepo.findAll();
	}
	
	public Ninja getNinjaById(Long id) {
		Optional<Ninja> chosenNinja = ninjaRepo.findById(id);
		if (chosenNinja.isPresent()) {
			return chosenNinja.get();
		}
		return null;
	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	public Ninja updateNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
