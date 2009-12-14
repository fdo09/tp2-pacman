package modelo.moviles;

enum Estados{VIVO, COMIDO}

public class Estado {
	
	private Estados estado;
	
	public Estado(){
		this.estado = Estados.VIVO;
	}
	
	public static Estado vivo(){
		Estado nuevoEstado = new Estado();
		nuevoEstado.estado = Estados.VIVO;
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
