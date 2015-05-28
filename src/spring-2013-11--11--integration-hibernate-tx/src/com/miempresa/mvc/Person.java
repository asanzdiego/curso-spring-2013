package com.miempresa.mvc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "PERSONS")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "NAME", unique = true, nullable = false)
	@NotEmpty
	private String name;

	@Column(name = "AGE", nullable = false)
	@NotNull
	@Range(min = 18, max = 25)
	private Integer age;

	public Person() {

	}

	public Person(final Integer id, final String name, final Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {

		return this.id;
	}

	public void setId(final Integer id) {

		this.id = id;
	}

	public String getName() {

		return this.name;
	}

	public void setName(final String name) {

		this.name = name;
	}

	public Integer getAge() {

		return this.age;
	}

	public void setAge(final Integer age) {

		this.age = age;
	}

	@Override
	public String toString() {

		return "Person [id=" + this.id + ", name=" + this.name + ", age="
				+ this.age + "]";
	}

}
