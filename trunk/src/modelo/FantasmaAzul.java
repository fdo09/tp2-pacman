package modelo;

public class FantasmaAzul extends Fantasma {

	private String estado;
	private boolean fueComido;
	private int posicionEnX;
	private int posicionEnY;
	
	public FantasmaAzul(int coordenadaEnX, int coordenadaEnY) {
		super(coordenadaEnX, coordenadaEnY);
						
	}

	public void mover() {

		//Ver si hay otra forma de hacer esto.
		
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

	private void huir() {
		// TODO Auto-generated method stub
		
	}

	private void atrapar() {
		// TODO Auto-generated method stub
		
	}

	private void deambular() {
		// TODO Auto-generated method stub
		
	}

}
