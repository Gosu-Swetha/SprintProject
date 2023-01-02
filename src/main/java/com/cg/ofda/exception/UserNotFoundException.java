package com.cg.ofda.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String msg)
	{
		super(msg);
	}

}
