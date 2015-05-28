package asanzdiego.spring.bd;

public class Test {

	private Integer id;

	private String name;

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

	@Override
	public String toString() {

		return "Test [id=" + this.id + ", name=" + this.name + "]";
	}

}
