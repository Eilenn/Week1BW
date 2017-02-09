package com.capgemini.fibonacci;

public class ResultOutOfRangeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2523217964962959616L;
	public ResultOutOfRangeException(Throwable cause) {
        super (cause);
    }

    public ResultOutOfRangeException (String message, Throwable cause) {
        super (message, cause);
    }
	 public ResultOutOfRangeException(String message)
     {
        super(message);
     }
}
