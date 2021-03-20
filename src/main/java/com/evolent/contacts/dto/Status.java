package com.evolent.contacts.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
	ACTIVE, INACTIVE;
	
	@JsonCreator
	public static Status create(String value) {
		return Status.valueOf(value.toUpperCase());
	}
	
	@JsonValue
    public String get() {
        return this.name().toLowerCase();
    }
}
