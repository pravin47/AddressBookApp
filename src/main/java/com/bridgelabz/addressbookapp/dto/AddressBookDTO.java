package com.bridgelabz.addressbookapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;



public  class AddressBookDTO {
	// @NotEmpty(message = "Name cannot be null")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "\n Incorrect User name")
	public String name;

	@NotEmpty(message = "Address cannot be null")
	public String address;

	@Pattern(regexp = "^[7-9]{1}[0-9]{9}$", message = "\n Incorrect phone number")
	public String phoneNumber;

	@NotBlank(message = "City cannot be Empty")
	public String city;

	@NotBlank(message = "State cannot be Empty")
	public String state;

	@Pattern(regexp = "^[1-9]{1}[0-9]{5}$", message = "Invalid Zip Code")
	public String zip;
}