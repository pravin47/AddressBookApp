package com.bridgelabz.addressbookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

//import lombok.Data;

// @Entity Annotation tells Hibernate to create a table
@Entity
@Table(name = "address_book")
public class AddressBookData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;
	private String address;

	@Column(name = "phone_number")
	private String phoneNumber;
	private String city;
	private String state;
	private String zip;

	public AddressBookData() {
	}

	public AddressBookData(AddressBookDTO addressBookDTO) {
		this.updateAddressBookData(addressBookDTO);
	}

	public void updateAddressBookData(AddressBookDTO addressBookDTO) {
		// TODO Auto-generated method stub
		this.id = id;
		this.name = addressBookDTO.name;
		this.address = addressBookDTO.address;
		this.phoneNumber = addressBookDTO.phoneNumber;
		this.city = addressBookDTO.city;
		this.state = addressBookDTO.state;
		this.zip = addressBookDTO.zip;
	}
}