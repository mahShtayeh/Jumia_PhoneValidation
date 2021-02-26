package com.jumia.models;

import java.io.Serializable;

import com.jumia.Entities.Customer;

//A class to model the customer's phone data 
//Serializable to be passed to the model -> servlet response then the view 
public class PhoneNumber implements Serializable {
	public static final CountryPhone[] AVAILABLE_COUNTRIES = {
			new CountryPhone("Cameroon", "+237", "\\(237\\)", "[2368]\\d{7,8}$"), 
			new CountryPhone("Ethiopia", "+251", "\\(251\\)", "[1-59]\\d{8}$"), 
			new CountryPhone("Morocco", "+212", "\\(212\\)", "[5-9]\\d{8}$"), 
			new CountryPhone("Mozambique", "+258", "\\(258\\)", "[28]\\d{7,8}$"), 
			new CountryPhone("Uganda", "+256", "\\(256\\)", "\\d{9}$")
	}; 
	
	private String customerName; 
	private CountryPhone countryPhone; 
	private boolean valid; //true for valid, false for invalid 
	private String number; 
	
	public PhoneNumber() {
	}
	
	public PhoneNumber(Customer customer) {
		this.customerName = customer.getName(); 
		
		//Splits the phone text into two tokens 
		//The first is used to determine the country 
		//The second for validation 
		String[] phoneTokens = customer.getPhone().split(" "); 
		String countryPorition = phoneTokens[0]; 
		this.number = phoneTokens[1]; 
		
		matchToCountryPhone(countryPorition); 
	}
	
	private void matchToCountryPhone(String countryPorition) {
		//Loop for the available countries to get the first match 
		//Then set the validation and the country then breaks the loop 
		for (int i = 0; i < PhoneNumber.AVAILABLE_COUNTRIES.length; i++) {
			if(PhoneNumber.AVAILABLE_COUNTRIES[i].belongsToTheCountry(countryPorition)) {
				countryPhone = PhoneNumber.AVAILABLE_COUNTRIES[i]; 
				valid = countryPhone.isValidPhone(number); 
				return; 
			} 
		} 
		
		//In case of an invalid country code 
		countryPhone = new CountryPhone("NoMatchingCountryName", "NoMatchingCountryCode"
				, "NoMatchingCountryCodeRegex", "NoMatchingCountryPhoneRegex"); 
		valid = false; 
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public CountryPhone getCountryPhone() {
		return countryPhone;
	}

	public void setCountryPhone(CountryPhone countryPhone) {
		this.countryPhone = countryPhone;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	} 
}
