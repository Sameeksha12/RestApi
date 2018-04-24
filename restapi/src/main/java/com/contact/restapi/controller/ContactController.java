package com.contact.restapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.contact.restapi.model.Contact;

import com.contact.restapi.service.ContactService;

@RestController
@RequestMapping("/api")
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contacts")
	public List<Contact> getAll(){
		return contactService.findAll();
		
	}
	@GetMapping("/contact/email")
	public Contact getByEmail(@RequestParam("email") String email){
		return contactService.getByEmail(email);
	}
	
	@RequestMapping(value="/contact/{id}" , method= RequestMethod.GET)
	public Contact getById(@PathVariable("id")int id){
		return contactService.searchById(id);
		}
	
	@GetMapping("/contact/group/city")
	public List<Contact> getGroupContactByCity(){
		return contactService.groupByCity();
	}
	@PostMapping("/contact")
	public Contact save(@RequestBody Contact contact){
		return contactService.save(contact);
	}
	@DeleteMapping("/contact/{id}")
	public void delete(@PathVariable("id")int id){
		contactService.delete(id);
	}
	@PutMapping("/contact/{id}")
	public Contact update(@RequestBody Contact contact, @PathVariable("id") int id){
		Contact updatedContact = contact;
		updatedContact.setId(id);
		return contactService.save(updatedContact);
	}

}
