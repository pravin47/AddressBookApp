package com.bridgelabz.addressbookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;

//import lombok.extern.slf4j.Slf4j;

/*@Service annotation is a specialization of @Component annotation. 
 *Its used with classes that provide some business functionalities. 
 */
@Service
//@Slf4j
public class AddressBookService implements IAddressBookService {

	@Autowired
	private AddressBookRepository addressBookRepository;

	//private List<AddressBookData> addressBookDataList = new ArrayList<>();

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepository.findAll();
	}

	@Override
	public AddressBookData getAddressBookDatById(int id) {
		return addressBookRepository.findById(id)
				.orElseThrow(() -> new AddressBookException("User " + id + " not found !!"));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(addressBookDTO);
		//log.debug("Address Book Data: " + addressBookData.toString());
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public AddressBookData updateAddressBookData(int id, AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = this.getAddressBookDatById(id);
		addressBookData.updateAddressBookData(addressBookDTO);
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public void deleteAddressBookData(int id) {
		// TODO Auto-generated method stub
		AddressBookData addressBookData = this.getAddressBookDatById(id);
		addressBookRepository.delete(addressBookData);
	}
}