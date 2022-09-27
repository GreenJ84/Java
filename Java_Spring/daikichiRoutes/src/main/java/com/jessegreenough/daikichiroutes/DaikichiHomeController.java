package com.jessegreenough.daikichiroutes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiHomeController {
	@RequestMapping("")
	public String welcomeDaikichi() {
		return ("Welcome!");
	}
	
	@RequestMapping("/today")
	public String todayDaikichiBlessing() {
		return ("Today you will find luck in all your endeavors!");
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrowDaikichiBlessing() {
		return ("Tomorrow, an opportunity will arise, so be sure to be open to new ideas!");
	}
	
	@RequestMapping("/travel/{city}")
	public String travelingTo(@PathVariable("city") String city) {
		return ("Congradulations! You will soon travel to " + city);
	}
	
	@RequestMapping("/lotto/{number}")
	public String fortune(@PathVariable("number") Integer number) {
		if (number%2 == 0) {
			return ("You will take a grand journey in the near future, but be weary of tempting offers!");
		}
		return ("You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.");
	}
}
