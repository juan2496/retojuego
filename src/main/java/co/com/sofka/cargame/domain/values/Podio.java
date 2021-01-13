package co.com.sofka.cargame.domain.values;

import co.com.sofka.cargame.domain.juego.Jugador;

public class Podio {
	private Jugador primerPuesto;
	private Jugador segundoPuesto;
	private Jugador tercerPuesto;
		
	public Podio() {
		super();
	}
	
	public Jugador getPrimerPuesto() {
		return primerPuesto;
	}
	public void setPrimerPuesto(Jugador primerPuesto) {
		this.primerPuesto = primerPuesto;
	}
	public Jugador getSegundoPuesto() {
		return segundoPuesto;
	}
	public void setSegundoPuesto(Jugador segundoPuesto) {
		this.segundoPuesto = segundoPuesto;
	}
	public Jugador getTercerPuesto() {
		return tercerPuesto;
	}
	public void setTercerPuesto(Jugador tercerPuesto) {
		this.tercerPuesto = tercerPuesto;
	}

	@Override
	public String toString() {
		return "primerPuesto=" + primerPuesto.getNombre() + " || segundoPuesto=" + segundoPuesto.getNombre() + "|| tercerPuesto="
				+ tercerPuesto.getNombre();
	}			
	
}
