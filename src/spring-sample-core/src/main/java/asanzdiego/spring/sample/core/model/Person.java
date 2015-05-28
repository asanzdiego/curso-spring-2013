package asanzdiego.spring.sample.core.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Person {

	@NotEmpty
	private String name;

	@Range(min = 18, max = 25)
	private Integer age;

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

		return "Person [name=" + this.name + ", age=" + this.age + "]";
	}

}
