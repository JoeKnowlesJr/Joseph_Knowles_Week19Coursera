package com.joeknowles.Week19.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joeknowles.Week19.models.ninjadojo.Dojo;
import com.joeknowles.Week19.models.ninjadojo.Ninja;
import com.joeknowles.Week19.repository.ninjadojo.DojoRepository;
import com.joeknowles.Week19.repository.ninjadojo.NinjaRepository;

@Service
public class NinjaDojoService {
	private NinjaRepository nRepo;
	private DojoRepository dRepo;
	
	public NinjaDojoService(NinjaRepository n, DojoRepository d) { nRepo = n; dRepo = d; }
	
	public boolean createDojo(Dojo d) {
		try {
			dRepo.save(d);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Ninja createNinja(Ninja n) { return nRepo.save(n); }
	public List<Dojo> allDojos() { return dRepo.findAll(); }

	public Optional<Dojo> findDojoById(Long id) { return dRepo.findById(id); }
}
