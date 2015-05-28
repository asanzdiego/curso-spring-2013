package com.miempresa.mvc;

public class MessageWeb {

	private String message;

	public String getMessage() {
		return this.message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public MessageWeb() {
		super();
	}

	public MessageWeb(final String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorWeb [message=" + this.message + "]";
	}

}
