package modelo.fijos;

public class Jugador {

	private String nombre;
	private int cantVidas;
	private int puntos;
	
	
	public Jugador(){
		
		this.nombre = "Jugador Desconocido";
		this.cantVidas = 3;
		this.puntos = 0;		
	}

	
	public Jugador(String nombre, int cantDeVidas, int puntos){
		
		this.nombre = nombre;
		this.cantVidas = cantDeVidas;
		this.puntos = puntos;
	}
	
	
	public int getCantVidas() {
		return this.cantVidas;
	}

	
	public int getPuntos() {
		return puntos;
	}


	public void ganarPuntos(int unValor) {
		this.puntos += unValor;
	}
	
	
	public void restarVida() {
		this.cantVidas -=1;
	}
	
	
	public void sumarVida(){
		this.cantVidas += 1;
	}

	/*
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	*/
	
	public String getNombre() {
		return this.nombre;
	}

}
