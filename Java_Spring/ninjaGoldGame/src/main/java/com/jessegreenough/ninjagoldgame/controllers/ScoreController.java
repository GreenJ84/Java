package com.jessegreenough.ninjagoldgame.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jessegreenough.ninjagoldgame.models.Score;
import com.jessegreenough.ninjagoldgame.models.Statement;

@Controller
public class ScoreController {
	Score score = new Score();
	ArrayList<Statement> events = new ArrayList<Statement>();
	String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
	Integer temp;
	Integer gold;
	Random rand = new Random();

	@RequestMapping("/")
	public String main(HttpSession session, Model model) {
		session.setAttribute("score", score.getScore());
		model.addAttribute("events", events);
		return "GameDisplay.jsp";
	}
	
	@RequestMapping("/farm")
	public String farm(HttpSession session) {
		temp = (Integer) session.getAttribute("score");
		gold = (Integer) rand.nextInt(10) +10;
		events.add(new Statement("You entered a farm and earned "+ gold+ " gold! (" + now+ ")", true));
		score.setScore(temp+gold);
		session.setAttribute("score", temp+gold);
		System.out.println(events);
		return "redirect:/";
	}
	@RequestMapping("/cave")
	public String cave(HttpSession session) {
		temp = (Integer) session.getAttribute("score");
		gold = (Integer) rand.nextInt(25) +5;
		events.add(new Statement("You entered a cave and earned "+ gold+ " gold! (" + now+ ")", true));
		score.setScore(temp+gold);
		session.setAttribute("score", temp+gold);
		return "redirect:/";
	}
	@RequestMapping("/house")
	public String house(HttpSession session) {
		temp = (Integer) session.getAttribute("score");
		gold = (Integer) rand.nextInt(40);
		events.add(new Statement("You entered a house and earned "+ gold+ " gold! (" + now+ ")", true));
		score.setScore(temp+gold);
		session.setAttribute("score", temp+gold);
		return "redirect:/";
	}
	@RequestMapping("/quest")
	public String quest(HttpSession session) {
		temp = (Integer) session.getAttribute("score");
		gold = (Integer) rand.nextInt(40) + 10;
		if (rand.nextInt(1000) % 2 == 1){
			score.setScore(temp+gold);
			session.setAttribute("score", temp+gold);
			events.add(new Statement("You completed a quest and earned "+ gold+ " gold! (" + now+ ")", true));
		}else {
			score.setScore(temp-gold);
			session.setAttribute("score", temp-gold);
			events.add(new Statement("You failed quest and lost "+ gold+ " gold! (" + now+ ")", false));
		}
		return "redirect:/";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		score.setScore(0);
		events.clear();
		return "redirect:/";
	}
}
