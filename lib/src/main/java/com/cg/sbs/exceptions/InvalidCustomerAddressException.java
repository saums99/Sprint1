package com.cg.sbs.exceptions;

public class InvalidCustomerAddressException extends RuntimeException {
	public InvalidCustomerAddressException (String msg)
	{
		super(msg);
	}

}
