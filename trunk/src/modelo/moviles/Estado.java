package modelo.moviles;

enum Estados{ATRAPAR, HUIR, COMIDO};

public class Estado {
	
	private Estados estado; 	
	
	public Estado(){
		this.estado = null;
	}
	
	public static Estado atrapar(){
		Estado nuevoEstado = new Estado();
		nuevoEstado.estado = Estados.ATRAPAR;
		return nuevoEstado;
	}
	
	public static Estado huir(){
		Estado nuevoEstado = new Estado();
		nuevoEstado.estado = Estados.HUIR;
		return nuevoEstado;
	}
	
	public static Estado comido(){
		Estado nuevoEstado = new Estado();
		nuevoEstado.estado = Estados.COMIDO;
		return nuevoEstado;
	}

	public boolean equals(Object obj2){
		if(!(obj2 instanceof Estado))
			return false;
		Estado unEstado = (Estado) obj2;
		if(this.estado == unEstado.estado)
			return true;
		else
			return false;
	}
	
}

