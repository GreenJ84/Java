package com.jessegreenough.dojosandninjas.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jessegreenough.dojosandninjas.models.Ninja;
import com.jessegreenough.dojosandninjas.services.DojoService;
import com.jessegreenough.dojosandninjas.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	
	@Autowired
	private NinjaService ninjaService;
	
	@Autowired
	private DojoService dojoService;
	
	@RequestMapping("/new")
	public String createNinja(
				@ModelAttribute("ninjaModel") Ninja ninja,
				Model model) {
		model.addAttribute("allDojos", dojoService.allDojos());
		return "newNinja.jsp";
	}
	
	@PostMapping("/new/create")
	public String newNinja(
				@ModelAttribute("ninjaModel") Ninja ninja,
				BindingResult results,
				Model model) {
		if(results.hasErrors()) {
			model.addAttribute("ninjaModel", ninja);
			return "newNinja.jsp";
		}
		ninjaService.createNinja(ninja);
		
		return "redirect:/ninjas/new";
	}

	
	
}
