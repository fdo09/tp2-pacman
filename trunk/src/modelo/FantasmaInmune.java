package modelo;



import java.util.Collection;
import fijos.*;

public class FantasmaInmune extends Fantasma  {

	private Tablero tablero;
	private Punto posicion;
	private Estados estado;
	
			
	public FantasmaInmune(Tablero tablero, Punto posicion){
	
		super(tablero, posicion);
		
	}


	@Override
	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean esComible(){
		//EL fantasmaInmune nunca puede ser comido
		return false;
	}
	
}