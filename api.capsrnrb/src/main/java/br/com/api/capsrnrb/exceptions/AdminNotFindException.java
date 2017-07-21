package br.com.api.capsrnrb.exceptions;

public class AdminNotFindException extends Exception {
	
	public AdminNotFindException() {
		super("admin not find... Verify your username and password.");
	}
}
