package modelo.fijos;

import java.util.Collection;
import modelo.moviles.Fantasma;
import modelo.moviles.Pacman;

enum EstadosJuego{EN_CURSO,GANADO,PERDIDO}

public class Juego{
	
	private static Juego instancia = new Juego();
	public static final String ARCHIVO = "xml/Tablero.xml";
	private Tablero tablero;
	private int nivel;
	private Jugador jugador;
	private EstadosJuego estadoJuego;


	public Juego(){
		this.cargarElementos();
		this.nivel = 1;
		this.jugador = new Jugador("Player1", 3, 0);
		this.estadoJuego = EstadosJuego.EN_CURSO;
	}

	
	private void cargarElementos() {
		CargaTablero cargador = new CargaTablero();
		this.tablero = cargador.cargar(ARCHIVO);
		this.tablero.cargarPersonajes();
		Pacman pacman = new Pacman (this.tablero, new Punto(15,21));
		this.tablero.addPacman(pacman);
	}


	public boolean juegoEnCurso(){
		if(this.jugador.getCantVidas() == 0){
			this.cambiarEstadoDelJuego(EstadosJuego.PERDIDO);
			return false;
		}
		else if(this.tablero.getSemillasRestantes() == 0){
			this.cambiarEstadoDelJuego(EstadosJuego.GANADO);
			return false;
		}
		else
			return true;
	}
	
	private void cambiarEstadoDelJuego(EstadosJuego unEstado){
		
		this.estadoJuego = unEstado;
				
	}
	
	public void aumentarNivel(){
		this.nivel += 1;
	}
	
	public int getNivel(){
		return this.nivel;
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
		return this.tablero;
	}

	
	public void aumentarDificultad(){
	
		Collection<Fantasma> fantasmas = this.tablero.getFantasmas();
		for(Fantasma unFantasma : fantasmas){
			
			unFantasma.aumentarVelocidad();
		}
	}
}
