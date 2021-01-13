package co.com.sofka.cargame.domain.juego;

import java.util.ArrayList;
import java.util.List;

import co.com.sofka.cargame.domain.carro.Carro;
import co.com.sofka.cargame.domain.values.Pista;
import co.com.sofka.cargame.domain.values.Podio;

public class Juego {
	
	private List<Jugador> jugadores;		
	private Pista pista;
	private Podio podio;
	private boolean jugando;
	
	public Juego() {
		super();
		jugadores = new ArrayList<Jugador>();
		podio = new Podio();
		jugando = true;
	}
		
	
	public void crearJugador(Integer idJugador, String nombre) {
		jugadores.add(new Jugador(idJugador,nombre,0, new Carro("azul",0)));
	}	
	
	public void movimientoJugador(int jugador, int numeroDado) {
		
		System.out.println("--------------------------------------");
		System.out.println(jugadores.get(jugador).getNombre());		
		if(jugando) {
			if(jugadores.get(jugador).getCarro().getDistanciaRecorrida() >= pista.getKilometros()) {
				System.out.println("YA ESTA EN LA META");
			}else{				
				//Tirar dado
				int resultado = numeroDado;
				jugadores.get(jugador).getCarro().avanzar(resultado);
				
				if(jugadores.get(jugador).getCarro().getDistanciaRecorrida() >= pista.getKilometros()) {
					if(podio.getPrimerPuesto() == null) {
						podio.setPrimerPuesto(jugadores.get(jugador));
					}else if(podio.getSegundoPuesto() == null) {
						podio.setSegundoPuesto(jugadores.get(jugador));
					}else if(podio.getTercerPuesto() == null) {
						podio.setTercerPuesto(jugadores.get(jugador));
					}																						
				}	
				
				if(podio.getPrimerPuesto() != null && podio.getSegundoPuesto() != null && podio.getTercerPuesto() != null) {						
					jugando = false;
				}
			}	
		}
		System.out.println("Distancia recorrida del carro " + jugadores.get(jugador).getCarro().getDistanciaRecorrida());
		System.out.println("--------------------------------------");
		
	}
	
	public int posicionActualCarro(int jugador) {		
		return jugadores.get(jugador).getCarro().getDistanciaRecorrida();		
	}
	
	public void reiniciar() {
		jugando = true;
		
		podio.setPrimerPuesto(null);
		podio.setSegundoPuesto(null);
		podio.setTercerPuesto(null);
		
		for(Jugador ju: jugadores) {
			ju.getCarro().setDistanciaRecorrida(0);
		}		
	}	

	public Pista getPista() {
		return pista;
	}

	public void setPista(Pista pista) {
		this.pista = pista;
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Podio getPodio() {
		return podio;
	}

	public void setPodio(Podio podio) {
		this.podio = podio;
	}

	public boolean isJugando() {
		return jugando;
	}

	public void setJugando(boolean jugando) {
		this.jugando = jugando;
	}			
}
