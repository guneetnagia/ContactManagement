package com.evolent.contacts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolent.contacts.CustomExceptions.ResourceNotFoundException;
import com.evolent.contacts.dto.Contacts;
import com.evolent.contacts.dto.Status;
import com.evolent.contacts.repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contacts> findAllContacts(){
		return contactRepository.findAll();
	}
	public Contacts addContact(Contacts contact){
		return contactRepository.save(contact);
	}
	public Contacts updateContact(Contacts newcontact){
		Contacts c = contactRepository.findById(newcontact.getContactId())
				.orElseThrow(ResourceNotFoundException::new);
		
		return contactRepository
				.save(
						c.getBuilder()
				.withContactId(newcontact.getContactId())
				.withFirstName(newcontact.getFirstName())
				.withLastName(newcontact.getLastName())
				.withEmail(newcontact.getEmail())
				.withPhoneNumber(newcontact.getPhoneNumber())
				.withStatus(newcontact.getStatus())
				.build());
	}
	public Contacts toggleStatus(Long contactId){
		Contacts c = contactRepository.findById(contactId)
				.orElseThrow(ResourceNotFoundException::new);
		String newStatus = c.getStatus().name() == "ACTIVE" ? "INACTIVE":"ACTIVE";
		return contactRepository
				.save(c.getBuilder()
						.withContactId(c.getContactId())
						.withFirstName(c.getFirstName())
						.withLastName(c.getLastName())
						.withEmail(c.getEmail())
						.withPhoneNumber(c.getPhoneNumber())
						.withStatus(Status.valueOf(newStatus))
						.build());
	}
}
