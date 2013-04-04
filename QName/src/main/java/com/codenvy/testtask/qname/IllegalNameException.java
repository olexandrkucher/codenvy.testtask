package com.codenvy.testtask.qname;

/**
 * Custom exception that occurs when the format of string
 * which using for obtaining the Qualified Names is not correct 
 * 
 * @author kol
 */
public class IllegalNameException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String name;
	
	/**
	 * @param name - string which you want parse, but it is not correct
	 */
	public IllegalNameException(String name) {
		this.name = name;
	}

	public String toString() {
		return "IllegalNameException. " + name + " this words are not XML Qualified Name.";
	}
}