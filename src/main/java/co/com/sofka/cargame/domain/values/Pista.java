package co.com.sofka.cargame.domain.values;

public class Pista {
	
	private Integer kilometros;
	private String nombre;
			
	public Pista() {
		super();
	}

	public Pista(Integer kilometros, String nombre) {
		super();
		this.kilometros = kilometros;
		this.nombre = nombre;
	}

	public Integer getKilometros() {
		return kilometros;
	}

	public void setKilometros(Integer kilometros) {
		this.kilometros = kilometros;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
