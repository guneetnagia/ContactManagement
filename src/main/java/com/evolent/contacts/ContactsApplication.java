package com.evolent.contacts;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.evolent.contacts.dto.Contacts;
import com.evolent.contacts.dto.Status;
import com.evolent.contacts.repository.ContactRepository;

@SpringBootApplication
public class ContactsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ContactsApplication.class, args);
		ContactRepository contactRepo = applicationContext.getBean(ContactRepository.class);
		Contacts c1 = Contacts.getBuilder()
		.withFirstName("Guneet")
		.withLastName("Nagia")
		.withPhoneNumber("1234567890")
		.withEmail("guneetnagia@abc.com")
		.withStatus(Status.ACTIVE)
		.build();
		
		Contacts c2 = Contacts.getBuilder()
				.withFirstName("Guneet2")
				.withLastName("Nagia2")
				.withPhoneNumber("1234567892")
				.withEmail("guneetnagia@abc2.com")
				.withStatus(Status.ACTIVE)
				.build();
		
		Contacts c3 = Contacts.getBuilder()
				.withFirstName("Guneet3")
				.withLastName("Nagia3")
				.withPhoneNumber("1234567893")
				.withEmail("guneetnagia@abc3.com")
				.withStatus(Status.ACTIVE)
				.build();
		
		Contacts c4 = Contacts.getBuilder()
				.withFirstName("Guneet4")
				.withLastName("Nagia4")
				.withPhoneNumber("1234567894")
				.withEmail("guneetnagia@abc4.com")
				.withStatus(Status.ACTIVE)
				.build();
		
		List<Contacts> list = Arrays.asList(c1,c2,c3,c4);
		contactRepo.saveAll(list);
	}

}
