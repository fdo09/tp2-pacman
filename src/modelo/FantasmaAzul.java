package modelo;

public class FantasmaAzul extends Fantasma {

	private String estado;
	private boolean fueComido;
	private int posicionEnX;
	private int posicionEnY;
	
	public FantasmaAzul(int coordenadaEnX, int coordenadaEnY) {
		super(coordenadaEnX, coordenadaEnY);
						
	}

	public void mover(String estado) {
		//Ver si hay otra forma de hacer esto.
		
		super.mover(estado);
		

	}

	public void huir() {
		// TODO Auto-generated method stub
		
	}

	public void atrapar() {
		// TODO Auto-generated method stub

		
	}

	public void deambular() {
		// TODO Auto-generated method stub
		
	}

}
