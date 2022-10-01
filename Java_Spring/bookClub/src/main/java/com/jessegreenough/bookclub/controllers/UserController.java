package com.jessegreenough.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jessegreenough.bookclub.models.LoginUser;
import com.jessegreenough.bookclub.models.User;
import com.jessegreenough.bookclub.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public String register(
				@ModelAttribute("newUser") User user,
				BindingResult results,
				HttpSession session){
		if (session.getAttribute("userId") != null) {
			return "redirect:/user/" + session.getAttribute("userId");
		}
		return "registration.jsp";
	}
	
	@PostMapping("/register/createUser")
	public String newUser(
				@Valid @ModelAttribute("newUser") User user,
				BindingResult results,
				Model model,
				HttpSession session) {
		
		session.removeAttribute("errors");
		
		if ( !user.getPassword().equals(user.getConfirmPassword())) {
			model.addAttribute("newUser", user);
			results.rejectValue("confirmPassword", "NoMatches", "The Confirm Password must match Password!");
			return "registration.jsp";
		}
		
		if (userService.getUserByEmail(user.getEmail()) != null) {
			session.setAttribute("errors", "User with this email already registered. Please login.");
			model.addAttribute("newUser", user);
			return "redirect:/user/login";
		} 
		
		else {
			if( results.hasErrors() ) {
				model.addAttribute("newUser", user);
				return "registration.jsp";
			}
			
			String hashed = BCrypt.hashpw( user.getPassword(), BCrypt.gensalt());
			user.setPassword(hashed);
		
			userService.save(user);
			
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getUserName());
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/login")
	public String login(
				@ModelAttribute("loginEvent") LoginUser login,
				BindingResult results,
				HttpSession session) {
		if (session.getAttribute("userId") != null) {	
			return "redirect:/user/" + session.getAttribute("userId");
		}
		return "login.jsp";
	}
	
	@PostMapping("/login/check")
	public String checkLogin(
				@Valid @ModelAttribute("loginEvent") LoginUser login,
				BindingResult results,
				Model model,
				HttpSession session) {
		
		session.removeAttribute("errors");
		
		if (userService.getUserByEmail(login.getEmail()) == null) {
			
			session.setAttribute("errors", "Email does not exist in system. Please Register!");
			model.addAttribute("loginEvent", login);
			return "redirect:/user/register";
		} 
		
		else {
			
			User userCheck = userService.getUserByEmail(login.getEmail());
			
			if (!BCrypt.checkpw(login.getPassword(), userCheck.getPassword())) {
				
				results.rejectValue("password", "NotMatches", "Invalid Password!");
				model.addAttribute("loginEvent", login);
				return "login.jsp";
			}
			
			else {
				
				session.setAttribute("userId", userCheck.getId());
				session.setAttribute("userName", userCheck.getUserName());
				return "redirect:/books";
			}
		}
	}
	
	@GetMapping("/clear")
	public String logOut(
				@ModelAttribute("loginEvent") LoginUser login,
				BindingResult results,
				HttpSession session) {
		
		session.invalidate();
		return "redirect:/user/login";
	}
	
	@GetMapping("/{id}/display")
	public String userBooks(
				@PathVariable("id") Long id,
				Model model,
				RedirectAttributes flash,
				HttpSession session) {
		
		if (session.getAttribute("userId") == null) {
			flash.addFlashAttribute("errors", "You are not logged in! Loggin or Register.");
			return "redirect:/user/login";
		}
		
		User thisUser = userService.getUserInfo(id);
		model.addAttribute("user", thisUser);
		System.out.println(thisUser.getBooks());
		return "userDisplay.jsp";
	}
	
	
	
}





