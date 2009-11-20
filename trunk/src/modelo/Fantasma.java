package modelo;

public abstract class Fantasma extends Personaje {

	
	private boolean fueComido;
	private String estado;
	private int posicionEnX;
	private int posicionEnY;

	public Fantasma(int coordenadaEnX, int coordenadaEnY) {
		
		this.fueComido = false;
		this.estado = "Atrapar";
		this.posicionEnX = coordenadaEnX;
		this.posicionEnY = coordenadaEnY;
		
	}
	
	
	public void mover(){
		
	// Si fue comido regresa a su casa, si no evalua.
		if (this.fueComido){
		      this.regresar();
		}	
		else{
			// evalua el estado del fantasma
			if(this.estado == "Huir"){
			
				this.huir();
			}
			if(this.estado == "Atrapar"){
			
				this.atrapar();
			}
		}
	}
	public void comido() {
		this.fueComido = true;
	}
	
	public abstract void huir();
	public abstract void regresar();
	public abstract void atrapar();
	
}
