package com.jessegreenough.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jessegreenough.dojosandninjas.models.Dojo;
import com.jessegreenough.dojosandninjas.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	
	@Autowired
	DojoService dojoService;

	@RequestMapping("/new")
	public String dojoForm(
				@ModelAttribute("dojoModel") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/new/create")
	public String createDojo(
				@ModelAttribute("dojoModel") Dojo dojo,
				BindingResult results,
				Model model) {
		if (results.hasErrors()) {
			model.addAttribute("dojoModel", dojo);
			return "newDojo.jsp";
		}
		dojoService.save(dojo);
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("/{id}")
	public String displayDojo(
				@PathVariable("id") Long id,
				Model model,
				RedirectAttributes redirectAttributes) {
		Dojo thisDojo = dojoService.findDojo(id);
		if (thisDojo != null) {
		model.addAttribute("dojoDetails", thisDojo);
		return "display.jsp";
		}
		redirectAttributes.addFlashAttribute("error", "No Dojo with that Id found. Please check your information.");
		return "redirect:/dojos/new";
	}
}
