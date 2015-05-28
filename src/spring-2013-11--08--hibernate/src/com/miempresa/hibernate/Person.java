package com.miempresa.hibernate;

public class Person {

	private String name;

	public String getName() {

		return this.name;
	}

	public void setName(final String name) {

		this.name = name;
	}

	@Override
	public String toString() {

		return "Person [name=" + this.name + "]";
	}

}
