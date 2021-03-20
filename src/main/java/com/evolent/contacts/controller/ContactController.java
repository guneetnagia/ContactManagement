package com.evolent.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evolent.contacts.dto.Contacts;
import com.evolent.contacts.service.ContactService;

@RestController
@RequestMapping("contacts/api")
public class ContactController {
	@Autowired
	private ContactService contactService;

	@GetMapping("/findAll")
	public ResponseEntity<List<Contacts>> findAllContacts(){
		return new ResponseEntity<List<Contacts>>(contactService.findAllContacts(),HttpStatus.OK);
	}
	@PostMapping("/addContact")
	public ResponseEntity<Contacts> addContact(@RequestBody Contacts contact){
		return new ResponseEntity<Contacts>(contactService.addContact(contact),HttpStatus.OK);
	}
	
	@PutMapping("/updateContact")
	public ResponseEntity<Contacts> updateContact(@RequestBody Contacts contact){
		return new ResponseEntity<Contacts>(contactService.updateContact(contact), HttpStatus.OK);
	}
	
	@PatchMapping("/toggleStatus/{contactId}")
	public ResponseEntity<Contacts> toggleStatus(@PathVariable Long contactId){
		return new ResponseEntity<Contacts>(contactService.toggleStatus(contactId),HttpStatus.OK);
	}
}
