package modelo.fijos;

enum EstadosJuego{EN_CURSO,GANADO,PERDIDO}

public class Juego {
	
	private static Juego instancia = new Juego();
	public static final String ARCHIVO= "xml/tablero.txt";
	private Tablero tablero;
	private int nivel;
	private Jugador jugador;
	private EstadosJuego estadoJuego;


	private Juego(){
		CargaTablero cargador = new CargaTablero();
		this.tablero = cargador.cargar(ARCHIVO);
		this.nivel = 1;
		this.jugador = new Jugador("Player1", 3, 0);
		this.estadoJuego = EstadosJuego.EN_CURSO;
	}

	
	public static Juego getInstancia(){
		return instancia;
	}


	public Jugador getJugador(){  
		return this.jugador; 
	}
	
	
	public void perder() {
		this.estadoJuego = EstadosJuego.PERDIDO;
	}
	
	
	public void ganar(){
		this.estadoJuego = EstadosJuego.GANADO;
	}

	
	public EstadosJuego obtenerEstado(){
		return this.estadoJuego;
	}
	
}
