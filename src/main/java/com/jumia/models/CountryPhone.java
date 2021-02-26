package com.jumia.models;

import java.io.Serializable;

//A class to model the country phone info 
//Serializable to be passed to the model -> servlet response then the view 
public class CountryPhone implements Serializable {
	private String countryName; 
	private String counrtyCode; 
	private String counrtyCodeRegex; 
	private String phoneRegex; 
	
	public CountryPhone() {
	}
	
	public CountryPhone(String countryName, String counrtyCode, String counrtyCodeRegex, String phoneRegex) {
		this.countryName = countryName;
		this.counrtyCode = counrtyCode;
		this.counrtyCodeRegex = counrtyCodeRegex;
		this.phoneRegex = phoneRegex;
	} 
	
	public String getCountryName() {
		return countryName;
	} 
	
	public String getCounrtyCode() {
		return counrtyCode;
	} 
	
	public String getPhoneRegex() {
		return phoneRegex;
	} 
	
	public boolean belongsToTheCountry(String countryCodePorition) {
		return countryCodePorition.matches(counrtyCodeRegex);
	}
	public boolean isValidPhone(String phone) {
		return phone.matches(phoneRegex);
	}
}
