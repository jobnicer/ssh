package org.ssh.common.exception;

public class ServiceException extends Exception{
	
	private static final long serialVersionUID = -71434260745841874L;
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Throwable cause) {
		super(cause);
	}
	
	public ServiceException(String message, Throwable cause) {
		super(message,cause);
	}

}
