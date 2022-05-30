package com.harshil.contact_system.service;

import java.util.List;


import com.harshil.contact_system.model.Contact;

public interface ContactService {

	Contact saveContact(Contact contact);

	List<Contact> getAllContacts();

	Contact getContactById(Long id);

	boolean deleteContact(Long id);

	Contact updateContact(Long id, Contact contact);

}
