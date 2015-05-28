package curso.modelo;

import org.apache.commons.lang.builder.EqualsBuilder;

public class Usuario {
	private Integer id;
	private String nombre;
	
	public Usuario(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Usuario() {
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return id+","+nombre;
	}

@Override
public boolean equals(Object o) {
	return EqualsBuilder.reflectionEquals(this, o);
}

}
