package co.com.sofka.cargame.domain.juego;


import co.com.sofka.cargame.domain.carro.Carro;

public class Jugador {
	
	Integer idJugador;
	String nombre;	
	Integer puntos;
	Carro carro;
				
	public Jugador() {
		super();
	}		

	public Jugador(Integer idJugador, String nombre, Integer puntos, Carro carro) {
		super();
		this.idJugador = idJugador;
		this.nombre = nombre;
		this.puntos = puntos;
		this.carro = carro;
	}	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	public Integer getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}		
}
