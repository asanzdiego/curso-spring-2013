package asanzdiego.spring.hibernate;

public class Person {

	private String name;

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
