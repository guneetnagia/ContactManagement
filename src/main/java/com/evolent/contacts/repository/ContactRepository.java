package com.evolent.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evolent.contacts.dto.Contacts;

@Repository
public interface ContactRepository extends JpaRepository<Contacts, Long>{
	
}
