package modelo.moviles;

enum Direcciones{ARRIBA, ABAJO, IZQUIERDA, DERECHA};

public class Direccion {
	
	private Direcciones sentido;
	
	public Direccion(){
		this.sentido = null;
	}

	public static Direccion derecha(){
		Direccion nuevaDireccion =  new Direccion();
		nuevaDireccion.sentido = Direcciones.DERECHA;
		return nuevaDireccion;
	}
	
	public static Direccion izquierda(){
		Direccion nuevaDireccion =  new Direccion();
		nuevaDireccion.sentido = Direcciones.IZQUIERDA;
		return nuevaDireccion;
	}
	
	public static Direccion arriba(){
		Direccion nuevaDireccion =  new Direccion();
		nuevaDireccion.sentido = Direcciones.ARRIBA;
		return nuevaDireccion;
	}
	
	public static Direccion abajo(){
		Direccion nuevaDireccion =  new Direccion();
		nuevaDireccion.sentido = Direcciones.ABAJO;
		return nuevaDireccion;
	}
	
	public boolean equals(Object obj2){
		if(!(obj2 instanceof Direccion))
			return false;
		Direccion unaDireccion = (Direccion) obj2;
		if(this.sentido == unaDireccion.sentido)
			return true;
		else
			return false;
	}
	
	

}
