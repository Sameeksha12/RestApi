package com.contact.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.contact.restapi.model.Contact;


public interface ContactRepository  extends CrudRepository<Contact, Integer>{
	@Query("SELECT contact from Contact contact where contact.email = :email ")
	Contact getByemail(@Param("email")String email);
	@Query("SELECT contact from Contact contact group by contact.address.city")
	List<Contact> groupByCity();
	@Query("SELECT contact from Contact contact where contact.workNumber= :phone or contact.cellNumber= :phone")
	List<Contact> getByphone(@Param("phone")String phone);
	
	@Query("SELECT contact from Contact contact where contact.id = :id ")
	Contact getById(@Param("id")int id);

}
