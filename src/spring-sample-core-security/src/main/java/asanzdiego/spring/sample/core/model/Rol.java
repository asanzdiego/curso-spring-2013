package asanzdiego.spring.sample.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ROLES")
public class Rol {

	@Id
	@Column(name = "ROL_NAME", unique = true, nullable = false)
	@NotEmpty
	private String rolName;

	@ManyToMany(fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			mappedBy = "roles",
			targetEntity = Person.class)
	private Set<Person> persons = new HashSet<Person>(0);

	public Rol() {

		super();
	}

	public Rol(final String rolName) {

		super();
		this.rolName = rolName;
	}

	public String getRolName() {

		return this.rolName;
	}

	public void setRolName(final String rolName) {

		this.rolName = rolName;
	}

	public Set<Person> getPersons() {

		return this.persons;
	}

	public void setPersons(final Set<Person> persons) {

		this.persons = persons;
	}

	@Override
	public String toString() {

		return "Rol [rolName=" + this.rolName + "]";
	}

}
