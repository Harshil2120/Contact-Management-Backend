package com.harshil.contact_system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshil.contact_system.model.Contact;
import com.harshil.contact_system.service.ContactService;

@CrossOrigin(value="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ContactController {
	

	private final ContactService contactService;

	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@PostMapping("/contacts")
    public Contact saveContact(@RequestBody Contact contact) {
	return contactService.saveContact(contact);
    }
	
	@GetMapping("/contacts")
    public List<Contact> getAllUsers(){
		return contactService.getAllContacts();
	}
	
	@GetMapping("/contacts/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable("id") Long id){
		Contact contact=null;
		contact=contactService.getContactById(id);
		return ResponseEntity.ok(contact);
	}
	
	@DeleteMapping("/contacts/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteContact(@PathVariable("id")Long id){
		boolean deleted=false;
		deleted=contactService.deleteContact(id);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", deleted);
		return ResponseEntity.ok(response);
		
	} 
	
	@PutMapping("/contacts/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable("id") Long id, @RequestBody Contact contact){
		contact=contactService.updateContact(id,contact);
		return ResponseEntity.ok(contact);
	}
	
}
