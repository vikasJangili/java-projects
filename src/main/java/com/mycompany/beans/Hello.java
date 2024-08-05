package com.mycompany.beans;

public class Hello {

	private String name ;
	private String message;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		System.out.println("setting name ");
		this.name = name;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String message() {
		return "hello "+ name + " " + message;
	}
}
