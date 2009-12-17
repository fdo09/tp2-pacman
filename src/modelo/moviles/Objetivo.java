package modelo.moviles;

enum Objetivos{ATRAPAR, HUIR, COMIDO, A_CASA};

public class Objetivo {
	
	private Objetivos objetivo; 	
	
	public Objetivo(){
		this.objetivo = null;
	}
	
	public static Objetivo atrapar(){
		Objetivo nuevoObjetivo = new Objetivo();
		nuevoObjetivo.objetivo = Objetivos.ATRAPAR;
		return nuevoObjetivo;
	}
	
	public static Objetivo huir(){
		Objetivo nuevoObjetivo = new Objetivo();
		nuevoObjetivo.objetivo = Objetivos.HUIR;
		return nuevoObjetivo;
	}
	
	public static Objetivo comido(){
		Objetivo nuevoObjetivo = new Objetivo();
		nuevoObjetivo.objetivo = Objetivos.COMIDO;
		return nuevoObjetivo;
	}

	public boolean equals(Object obj2){
		if(!(obj2 instanceof Objetivo))
			return false;
		Objetivo unObjetivo = (Objetivo) obj2;
		if(this.objetivo == unObjetivo.objetivo)
			return true;
		else
			return false;
	}

	public static Objetivo aCasa() {
		Objetivo nuevoObjetivo = new Objetivo();
		nuevoObjetivo.objetivo = Objetivos.A_CASA;
		return nuevoObjetivo;	}
}

