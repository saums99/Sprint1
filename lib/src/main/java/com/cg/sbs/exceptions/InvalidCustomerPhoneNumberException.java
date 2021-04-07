package com.cg.sbs.exceptions;

public class InvalidCustomerPhoneNumberException extends RuntimeException {
	public InvalidCustomerPhoneNumberException (String msg)
	{
		super(msg);
	}
}