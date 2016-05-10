package org.ssh.common.exception;

public class ActionException extends Exception{
	
	private static final long serialVersionUID = 105188045974566349L;
	
	public ActionException(Class<?> clazz, String message) {
		super(message);
	}
	
	public ActionException(Class<?> clazz, Throwable cause) {
		super(cause);
	}
	
	public ActionException(Class<?> clazz, String message, Throwable cause) {
		super(message,cause);
	}

}



