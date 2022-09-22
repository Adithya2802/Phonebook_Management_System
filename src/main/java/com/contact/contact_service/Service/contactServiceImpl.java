package com.contact.contact_service.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.contact_service.Entity.Contact;

@Service
public class contactServiceImpl implements contactService {

	
	@Autowired
	contactService contactservice;
	
	List<Contact> list=List.of(new Contact(1L,"amit@gmail.com","amit",1311L));
	
	@Override
	public List<Contact> getUserContact(Long userId) {
		// TODO Auto-generated method stub
		return list.stream().filter(contact -> contact.getUserid().equals(userId)).collect(Collectors.toList());
	}

}
