package com.contact.restapi.service;

import java.util.List;

import com.contact.restapi.model.Contact;;
public interface ContactService {
	List<Contact> findAll();
	List<Contact> getByPhone(String phone);
	Contact getByEmail(String email);
	List<Contact> groupByCity();
	Contact save(Contact contact);
	void delete(int id);
	Contact searchById(int id);
	
	
	

}
