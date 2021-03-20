package com.evolent.contacts.CustomExceptions;

public class ResourceNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = -6648729889213896138L;

	public ResourceNotFoundException(){
		super("Resource Not Found.");
	}
	
	public String getMessage(){
		return "Resource Not Found.";
	}

}
