package com.jumia.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jumia.Entities.Customer;
import com.jumia.models.PhoneNumber;
import com.jumia.services.CustomerService;

@Controller
@RequestMapping("/")
public class PhoneValidationController {
	@Autowired
	private CustomerService customerService; 
	
	@GetMapping("phone")
	public String phoneValidationPage(Model model) { 
		//Retrieving the Sqlite date from the sample 
		Iterable<Customer> customers = customerService.getCustomersPage(); 
		
		//Initialize a list to append the phones objects in 
		List<PhoneNumber> phoneNumbers = new ArrayList<>(); 
		
		//For each customer initialize a phone object 
		//The customer object constructor initializes the state of the phone 
		for (Customer customer : customers) {
			phoneNumbers.add(new PhoneNumber(customer)); 
		}
		
		//Add the list to the model, to be copied to the servlet response 
		//To be used later by the view 
		model.addAttribute("phoneNumbers", phoneNumbers); 
		
		//Return the name of the view 
		return "PhoneValidationTemp"; 
	}
}