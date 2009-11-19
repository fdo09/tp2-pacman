package modelo;

public abstract class Fantasma extends Personaje {

	private String estado;
	private boolean fueComido;
	private int posicionEnX;
	private int posicionEnY;

	public Fantasma(int coordenadaEnX, int coordenadaEnY) {
		
		this.estado = "Deambulando";
		this.fueComido = false;
		
		this.posicionEnX = coordenadaEnX;
		this.posicionEnY = coordenadaEnY;
		
	}

	public void mover(){
			if(this.estado == "Deambular"){
			
				this.deambular();
			}
			if(this.estado == "Huir"){
			
				this.huir();
			}
			if(this.estado == "Atrapar"){
			
				this.atrapar();
			}
	}
	
	public abstract void huir();
	public abstract void deambular();
	public abstract void atrapar();
	
}
