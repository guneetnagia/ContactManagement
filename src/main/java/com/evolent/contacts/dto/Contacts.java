package com.evolent.contacts.dto;

/*
 * Builder pattern
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contacts")
public class Contacts {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long contactId;
	@Column(name="fname")
	private String firstName;
	@Column(name="lname")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="phNumber")
	private String phoneNumber;
	//@Enumerated(EnumType.STRING)
	private Status status;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	//@Enumerated(EnumType.ORDINAL)
	public Status getStatus() {
		return status;
	}
	public long getContactId() {
		return contactId;
	}
	
	public static ContactsBuilder getBuilder(){
		return new ContactsBuilder();
	}

	// Builder inner class
	public static class ContactsBuilder{
		private long contactId;
		private String firstName;
		private String lastName;
		private String email;
		private String phoneNumber;
		private Status status;
		
		public ContactsBuilder withContactId(final Long contactId){
			this.contactId = contactId;
			return this;
		}
		public ContactsBuilder withFirstName(final String firstName){
			this.firstName = firstName;
			return this;
		}
		public ContactsBuilder withLastName(final String lastName){
			this.lastName = lastName;
			return this;
		}
		public ContactsBuilder withEmail(final String email){
			this.email = email;
			return this;
		}
		public ContactsBuilder withPhoneNumber(final String phoneNumber){
			this.phoneNumber = phoneNumber;
			return this;
		}
		public ContactsBuilder withStatus(final Status status){
			this.status = status;
			return this;
		}
		
		public Contacts build(){
			Contacts c = new Contacts();
			c.contactId = this.contactId;
			c.firstName = this.firstName;
			c.lastName = this.lastName;
			c.email = this.email;
			c.phoneNumber = this.phoneNumber;
			c.status = this.status;
			return c;
		}
	}
}
