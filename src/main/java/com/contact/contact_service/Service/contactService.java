package com.contact.contact_service.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contact.contact_service.Entity.Contact;

public interface contactService {
	
	public List<Contact> getUserContact(Long userId);

}
