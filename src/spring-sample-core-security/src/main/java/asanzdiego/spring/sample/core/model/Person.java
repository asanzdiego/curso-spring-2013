package asanzdiego.spring.sample.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "PERSONS")
public class Person {

	@Id
	@Column(name = "PERSON_NAME", unique = true, nullable = false)
	@NotEmpty
	private String personName;

	@Column(name = "PERSON_AGE", nullable = false)
	@NotNull
	@Range(min = 18, max = 25)
	private Integer personAge;

	@Column(name = "PERSON_PASSWORD", nullable = false, length = 10)
	@NotEmpty
	@Length(min = 6, max = 10)
	private String personPassword;

	@Column(name = "PERSON_ENABLED", nullable = false)
	private boolean personEnabled;

	@ManyToMany(fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			targetEntity = Rol.class)
	@JoinTable(name = "PERSON_ROLES",
			joinColumns = { @JoinColumn(name = "PERSON_NAME", nullable = false) },
			inverseJoinColumns = { @JoinColumn(name = "ROL_NAME",
					nullable = false) })
	private Set<Rol> roles = new HashSet<Rol>(0);

	public String getPersonName() {

		return this.personName;
	}

	public void setPersonName(final String personName) {

		this.personName = personName;
	}

	public Integer getPersonAge() {

		return this.personAge;
	}

	public void setPersonAge(final Integer personAge) {

		this.personAge = personAge;
	}

	public String getPersonPassword() {

		return this.personPassword;
	}

	public void setPersonPassword(final String personPassword) {

		this.personPassword = personPassword;
	}

	public boolean isPersonEnabled() {

		return this.personEnabled;
	}

	public void setPersonEnabled(final boolean personEnabled) {

		this.personEnabled = personEnabled;
	}

	public String getPersonRoles() {

		if (this.roles == null) {
			return "";
		}

		String personRoles = "";
		for (final Rol rol : this.roles) {
			personRoles = personRoles + rol.getRolName() + " ";
		}
		return personRoles;
	}

	public Set<Rol> getRoles() {

		return this.roles;
	}

	public void setRoles(final Set<Rol> roles) {

		this.roles = roles;
	}

	@Override
	public String toString() {

		return "Person [personName=" + this.personName + ", personAge="
				+ this.personAge + ", personPassword=" + this.personPassword
				+ ", personEnabled=" + this.personEnabled + ", roles="
				+ this.roles + "]";
	}

}
