package com.cg.sbs.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	CustomerNotFoundException(String msg)
	{
		super(msg);
	}

}
