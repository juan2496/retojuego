package co.com.sofka.cargame.domain.carro;

public class Carro {
	
	private String calor;
	private Integer distanciaRecorrida;
	
	public Carro() {
		super();
	}		

	public Carro(String calor, Integer distanciaRecorrida) {
		super();
		this.calor = calor;
		this.distanciaRecorrida = distanciaRecorrida;
	}

	public String getCalor() {
		return calor;
	}

	public void setCalor(String calor) {
		this.calor = calor;
	}

	public Integer getDistanciaRecorrida() {
		return distanciaRecorrida;
	}

	public void setDistanciaRecorrida(Integer distanciaRecorrida) {
		this.distanciaRecorrida = distanciaRecorrida;
	}

	public void avanzar(int resultado) {
		this.distanciaRecorrida += resultado*100;
		
	}
	
	
	
	
	
	
}
