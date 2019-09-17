package com.joeknowles.Week19.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joeknowles.Week19.models.ninjadojo.Dojo;
import com.joeknowles.Week19.models.ninjadojo.Ninja;
import com.joeknowles.Week19.models.ninjadojo.NinjaFormObject;
import com.joeknowles.Week19.services.NinjaDojoService;

@Controller
public class NinjaDojoController {
	private NinjaDojoService service;
	
	public NinjaDojoController(NinjaDojoService s) { service = s; }
	
	@PostMapping("/ninjadojo")
	public String dojohome( ) {
		return "ninjadojo/index";
	}
	
	@PostMapping("ninjadojo/newNinja")
	public String newNinja(Model model) {
		model.addAttribute("dojos", service.allDojos());
		model.addAttribute("nfo", new NinjaFormObject());
		return "ninjadojo/newNinja";
	}
	
	@PostMapping("ninjadojo/newDojo")
	public String newDojo() {
		return "ninjadojo/newDojo";
	}
	
	@GetMapping("ninjadojo/show/{id}")
	public String showGet(Model model, @PathVariable(name="id", required=false) Long id) {
		List<Dojo> dojos = service.allDojos();
		if (id != null) {
			Optional<Dojo> oD = service.findDojoById(id);
			if (oD.isPresent()) {
				model.addAttribute("dojo", oD.get());
			}
		} else {
			model.addAttribute("dojo", dojos.get(0));
		}
		model.addAttribute("dojos", dojos);
		return "ninjadojo/ndShow";
	}
	
	@PostMapping("ninjadojo/show")
	public String showPost(Model model) {
		List<Dojo> dojos = service.allDojos();
		model.addAttribute("dojo", dojos.get(0));
		model.addAttribute("dojos", dojos);
		return "ninjadojo/ndShow";
	}
	
	@GetMapping("/ninjadojo/createDojo")
	public String createDojo(Model model, @RequestParam("name") String n) {
		model.addAttribute("dojos", service.allDojos());
		Dojo d = new Dojo(n);
		if (service.createDojo(d)) {
			return "redirect:/ninjadojo/show/" + d.getId();
		}
		model.addAttribute("error", true);
		model.addAttribute("msg", "Error creating dojo!");	
		return "ninjadojo/newDojo";
	}
	
	@PostMapping("/ninjadojo/createNinja")
	public String createNinja(Model model, @ModelAttribute("nfo") NinjaFormObject nfo) {
		Long dId = nfo.getDojo_id();
		Optional<Dojo> oD = service.findDojoById(dId);
		if (oD.isPresent()) {
			Ninja n = new Ninja(nfo.getFirstName(), nfo.getLastName(), nfo.getAge(), oD.get());
			service.createNinja(n);
		}
		model.addAttribute("dojos", service.allDojos());
//		model.addAttribute("selected", )
		return "redirect:/ninjadojo/show/" + dId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
