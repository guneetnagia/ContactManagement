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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("contacts/api")
@Api(produces = "application/json", value = "Operations pertaining to Contact management")
public class ContactController {
	@Autowired
	private ContactService contactService;

	@GetMapping("/findAll")
	@ApiOperation(value = "Get the list of contacts", response = ResponseEntity.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully - got the list of contact"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    })
	public ResponseEntity<List<Contacts>> findAllContacts(){
		return new ResponseEntity<List<Contacts>>(contactService.findAllContacts(),HttpStatus.OK);
	}
	
	
	@PostMapping("/addContact")
	@ApiOperation(value = "Add contact", response = ResponseEntity.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully - added contact"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    })
	public ResponseEntity<Contacts> addContact(@RequestBody Contacts contact){
		return new ResponseEntity<Contacts>(contactService.addContact(contact),HttpStatus.OK);
	}
	
	
	
	@PutMapping("/updateContact")
	@ApiOperation(value = "update contact", response = ResponseEntity.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully - upadte the contact"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    })
	public ResponseEntity<Contacts> updateContact(@RequestBody Contacts contact){
		return new ResponseEntity<Contacts>(contactService.updateContact(contact), HttpStatus.OK);
	}
	
	@PatchMapping("/toggleStatus/{contactId}")
	@ApiOperation(value = "Active/Inactive contact", response = ResponseEntity.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully - Toggle contact status"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    })
	public ResponseEntity<Contacts> toggleStatus(@PathVariable Long contactId){
		return new ResponseEntity<Contacts>(contactService.toggleStatus(contactId),HttpStatus.OK);
	}
}
