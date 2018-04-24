package com.contact.restapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.restapi.model.Contact;
import com.contact.restapi.repository.ContactRepository;
import com.contact.restapi.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<Contact> findAll() {
		
		return (List<Contact>) contactRepository.findAll();
	}

	@Override
	public List<Contact> getByPhone(String phone) {
		return (List<Contact>) contactRepository.getByphone(phone);
	}

	@Override
	public Contact getByEmail(String email) {
		
		return contactRepository.getByemail(email);
	}

	@Override
	public List<Contact> groupByCity() {
		
		return contactRepository.groupByCity();
	}

	@Override
	public Contact save(Contact contact) {
		
		return contactRepository.save(contact);
	}

	@Override
	public void delete(int id) {
		contactRepository.delete(id);
		
	}

	@Override
	public Contact searchById(int id) {
		return contactRepository.getById(id);
	}

}
