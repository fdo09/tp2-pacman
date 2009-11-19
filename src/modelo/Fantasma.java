package modelo;

public abstract class Fantasma extends Personaje {

	
	private boolean fueComido;
	private int posicionEnX;
	private int posicionEnY;

	public Fantasma(int coordenadaEnX, int coordenadaEnY) {
		
		this.fueComido = false;
		
		this.posicionEnX = coordenadaEnX;
		this.posicionEnY = coordenadaEnY;
		
	}
	
	
	public void mover(String estado){
			if(estado == "Deambular"){
			
				this.deambular();
			}
			if(estado == "Huir"){
			
				this.huir();
			}
			if(estado == "Atrapar"){
			
				this.atrapar();
			}
	}
	
	public abstract void huir();
	public abstract void deambular();
	public abstract void atrapar();
	
}
