package amex.shoppingcart.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {

	
	
	@GetMapping("/test")
	public String getTodayDateAndTimeMessage() {
		
		return new Date().toString();
		
	}
}
