package com.vbaggio.ecom.services.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException{

    /**
     * 
     */
    @Serial
    private static final long serialVersionUID = 1L;
	
	public DatabaseException() {
		super("Database failure");
	}
	
	public DatabaseException(String message) {
		super(message);
	}
}
