package com.jessegreenough.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/omikuji")
public class OmikujiControllers {
	
	@RequestMapping("")
	public String omikujiForm() {
		
		return "omikujiForm.jsp";
	}
	
	@PostMapping("/submit")
	public String formSubmit(
			@RequestParam (value="number") Integer number,
			@RequestParam (value="nameCity") String nameCity,
			@RequestParam (value="namePerson") String namePerson,
			@RequestParam (value="endeavorHobby") String hobby,
			@RequestParam (value="livingThing") String livingThing,
			@RequestParam (value="somethingNice") String somethingNice,
			HttpSession session){
		
		session.setAttribute("number", number);
		session.setAttribute("city", nameCity);
		session.setAttribute("person", namePerson);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("nice", somethingNice);
		
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/show")
	public String omikujiShow(HttpSession session, Model model) {
		
		Integer number = (Integer) session.getAttribute("number");
		String city = (String) session.getAttribute("city");
		String person = (String) session.getAttribute("person");
		String hobby = (String) session.getAttribute("hobby");
		String livingThing = (String) session.getAttribute("livingThing");
		String nice = (String) session.getAttribute("nice");
		
		model.addAttribute("number", number);
		model.addAttribute("city", city);
		model.addAttribute("person", person);
		model.addAttribute("hobby", hobby);
		model.addAttribute("livingThing", livingThing);
		model.addAttribute("nice", nice);
		
		return "omikujiDisplay.jsp";
	}

}
