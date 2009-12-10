package modelo.fijos;

enum EstadosJuego{EN_CURSO,GANADO,PERDIDO}

public class Juego {
	
	private static Juego instancia = new Juego();
	public static final String ARCHIVO = "xml/tablero.xml";
	private Tablero tablero;
	private int nivel;
	private Jugador jugador;
	private EstadosJuego estadoJuego;


	public Juego(){
		CargaTablero cargador = new CargaTablero();
		this.tablero = cargador.cargar(ARCHIVO);
		this.tablero.cargarPersonajes();
		this.nivel = 1;
		this.jugador = new Jugador("Player1", 3, 0);
		this.estadoJuego = EstadosJuego.EN_CURSO;
	}

	
	public boolean juegoEnCurso(){
		if(this.jugador.getCantVidas() == 0){
			this.estadoJuego = EstadosJuego.PERDIDO;
			return false;
		}
		else if(this.tablero.getSemillasRestantes() == 0){
			this.estadoJuego = EstadosJuego.GANADO;
			return false;
		}
		else
			return true;
	}
	
	
	public static Juego getInstancia(){
		return instancia;
	}
	
	public static void reiniciarJuego(){
		instancia = new Juego();
	}


	public Jugador getJugador(){  
		return this.jugador; 
	}

	
	public EstadosJuego getEstado(){
		return this.estadoJuego;
	}


	public Tablero getTablero() {
		return tablero;
	}
	
}
