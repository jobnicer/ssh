package org.ssh.common.exception;

public class DaoException extends Exception{
	
	private static final long serialVersionUID = -8801718407102159973L;
	
//	private Logger logger = null;

	public DaoException(Class<?> clazz, String message) {
		super(message);
//		logger = LoggerFactory.getLogger(clazz);
//		logger.error(message);
	}
	
	public DaoException(Class<?> clazz, Throwable cause) {
		super(cause);
//		logger = LoggerFactory.getLogger(clazz);
//		logger.error(cause.getMessage(),cause);
	}
	
	public DaoException(Class<?> clazz, String message, Throwable cause) {
		super(message,cause);
//		logger = LoggerFactory.getLogger(clazz);
//		logger.error(message,cause);
	}

}



