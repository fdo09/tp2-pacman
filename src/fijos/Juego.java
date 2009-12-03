package fijos;

public class Juego {
	
	private static Juego instancia = new Juego();
	public static final String ARCHIVO= "./tablero.txt";
	private Tablero tablero;
	private int nivel;
	private Jugador jugador;

	private Juego(){
		CargaTablero cargador = new CargaTablero();
		this.tablero = cargador.cargar(ARCHIVO);
		this.nivel = 1;
		this.jugador = new Jugador("Player1", 3, 0);
	}

	public static Juego getInstancia(){
		return instancia;
	}


	public Jugador getJugador(){  
		return this.jugador; 
	}
	
	
	public void perder() {

	}
	
	public void ganar(){
		
	}
	
	

}
