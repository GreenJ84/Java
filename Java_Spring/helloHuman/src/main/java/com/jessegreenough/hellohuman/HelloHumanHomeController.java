package com.jessegreenough.hellohuman;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanHomeController {
	
	@RequestMapping("/")
	public String helloHuman(@RequestParam(value="fName", required=false) String fName, @RequestParam(value="lName", required=false) String lName, @RequestParam(value="times", required=false) Integer repetitions) {
		if (repetitions == null) {
			repetitions=0;
		}
		if(fName != null) {
			if (lName != null) {
				String fullName = ("Hello " + fName + " " + lName);
				while (repetitions > 0) {
					fullName = fullName.concat("\nHello " + fName + " " + lName);
					repetitions--;
				}
				return fullName;
			}
			String onlyFirst = ("Hello " + fName);
			while (repetitions > 0) {
				onlyFirst = onlyFirst.concat("\nHello " + fName);
				repetitions--;
			}
			return onlyFirst;
			}
		String blank = ("Hello Human");
		while (repetitions > 0) {
			blank = blank.concat("\nHello Human");
			repetitions--;
		}
		return blank;
	}
		

	

//	
	@RequestMapping("/{firstName}/{lastName}")
	public String helloFirstName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
		if (lastName != null) {
			return ("Hello " + firstName + " " + lastName);
		}
		return ("Hello " + firstName);
		
	}
}
	