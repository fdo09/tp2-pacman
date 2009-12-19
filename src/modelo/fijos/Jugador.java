package modelo.fijos;

public class Jugador {


	private int cantVidas;
	private int puntos;
	private int cantVidasInicial;
	
	
	public Jugador(){
		
		
		this.cantVidas = 3;
		this.puntos = 0;		
	}

	
	public Jugador(int cantDeVidas, int puntos){
		
	
		this.cantVidas = cantDeVidas;
		this.cantVidasInicial = cantDeVidas;
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
	
	public void resetearPuntos(){
		this.puntos = 0;
	}
	
	public void resetearVidas(){
		this.cantVidas = this.cantVidasInicial;
	}
	
	
	public void restarVida() {
		this.cantVidas -=1;
	}
	
	
	public void sumarVida(){
		int cantVidasMaximas = 3;
		if(this.cantVidas <= cantVidasMaximas)
			this.cantVidas += 1;
		
	}

	

}
