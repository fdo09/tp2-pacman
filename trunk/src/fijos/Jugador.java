package fijos;

public class Jugador {

	private String nombre;
	private int cantVidas;
	private int puntos;
	private Juego juego;
	
	public Jugador(){
		
		this.nombre = "";
		this.cantVidas = 0;
		this.puntos = 0;
		
	}
	
	public Jugador(String nombre, int cantDeVidas, int puntos){
		
		this.nombre = nombre;
		this.cantVidas = cantDeVidas;
		this.puntos = puntos;
		
	}

	public void sumarPuntos(int unValor) {
		this.puntos += unValor;
		
	}

	public void restarVida() {
		this.cantVidas -=1;
		if(this.cantVidas == 0){
			
			juego.perder();
						
		}
	}

}