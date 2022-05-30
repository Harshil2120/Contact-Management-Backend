package com.harshil.contact_system.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshil.contact_system.entity.ContactEntity;
import com.harshil.contact_system.model.Contact;
import com.harshil.contact_system.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact saveContact(Contact contact) {
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		contactRepository.save(entity);
		return contact;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> contactEntities =contactRepository.findAll();
		List<Contact> contacts= contactEntities.stream().map(contactEntity ->new Contact(
				 contactEntity.getId(),
				 contactEntity.getFirstName(),
				 contactEntity.getLastName(),
				 contactEntity.getEmailId(),
				 contactEntity.getPhone_number()
				)).collect(Collectors.toList());
		return contacts;
	}

	@Override
	public Contact getContactById(Long id) {
		ContactEntity contactEntity=contactRepository.findById(id).get();
		Contact contact=new Contact();
		BeanUtils.copyProperties(contactEntity, contact);
		return contact;
	}

	@Override
	public boolean deleteContact(Long id) {
		ContactEntity contactEntity=contactRepository.findById(id).get();
		contactRepository.delete(contactEntity);
		return true;
	}

	@Override
	public Contact updateContact(Long id, Contact contact) {
		ContactEntity contactentity=contactRepository.findById(id).get();
		contactentity.setEmailId(contact.getEmailId());
		contactentity.setFirstName(contact.getFirstName());
		contactentity.setLastName(contact.getLastName());
		contactentity.setEmailId(contact.getEmailId());
		contactRepository.save(contactentity);
		return contact;
	}
	
	

}
