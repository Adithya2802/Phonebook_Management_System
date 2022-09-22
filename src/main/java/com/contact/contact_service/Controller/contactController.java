package com.contact.contact_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.contact_service.Entity.Contact;
import com.contact.contact_service.Service.contactService;

@RestController
@RequestMapping("contact")
public class contactController {
	
	@Autowired
	private contactService contactservice;

	@RequestMapping("/user/{userId}")
	public List<Contact> getContacts(@PathVariable("userId") Long userId){
		return this.contactservice.getUserContact(userId);
		
		
	}
	
}
