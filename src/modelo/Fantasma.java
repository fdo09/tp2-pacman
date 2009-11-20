package modelo;

enum Estados{ATRAPAR, HUIR, INMUNE, COMIDO};

public abstract class Fantasma implements Personaje {

	private int posicionEnX;
	private int posicionEnY;
	protected Estados estado; 

	public Fantasma(int coordenadaEnX, int coordenadaEnY) {
		
		this.estado = Estados.ATRAPAR;
		this.posicionEnX = coordenadaEnX;
		this.posicionEnY = coordenadaEnY;
		
	}
	
	
	public void mover(){
		
		switch (this.estado){
			case ATRAPAR:
				this.atrapar();
			case HUIR:
				this.huir();
			case COMIDO:
				this.regresar();
			//falta ver que se hace cuando esta INMUNE
		}
	}
	
	public abstract void huir();
	public abstract void regresar();
	public abstract void atrapar();
	
}
