package com.java18.nikolaos.listColth.exception;

public class ClothNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	Integer id; 
	public ClothNotFoundException() { }
	
	
	public ClothNotFoundException(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	public ClothNotFoundException(String message, int clothId) {
		super(message);
	}
	
	public ClothNotFoundException(Throwable cause) {
		super(cause);
	}
	public ClothNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public ClothNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	
}
