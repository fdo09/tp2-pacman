package modelo.fijos;

import java.util.Collection;

import modelo.moviles.Fantasma;
import modelo.moviles.Objetivo;
import modelo.moviles.Pacman;

enum EstadosJuego{EN_CURSO,GANADO,PERDIDO}

public class Juego{
	
	private static Juego instancia = new Juego();
	public static final String ARCHIVO = "xml/Tablero.xml";
	private Tablero tablero;
	private int nivel;
	private Jugador jugador;
	private static EstadosJuego estadoJuego;
	private static final int cantidadDeNiveles = 4;


	public Juego(){
		this.cargarElementos();
		this.nivel = 1;
		this.jugador = new Jugador(3, 0);
		Juego.estadoJuego = EstadosJuego.EN_CURSO;
	}

	
	private void cargarElementos() {
		CargaTablero cargador = new CargaTablero();
		this.tablero = cargador.cargar(ARCHIVO);
		this.tablero.cargarPersonajes();
		Pacman pacman = new Pacman (this.tablero, new Punto(15,21));
		this.tablero.addPacman(pacman);
	}



	
	public static void setEstadoDelJuego(EstadosJuego unEstado){
		
		estadoJuego = unEstado;
			
				
	}
	
	public void aumentarNivel(){
		this.nivel += 1;
		this.reestablecerTablero();
		this.establecerObjetivoDeFantasmas();
		this.aumentarDificultad();
	}
	
	private void establecerObjetivoDeFantasmas() {
		Collection<Fantasma> fantasmas = this.tablero.getFantasmas();
		for(Fantasma unFantasma : fantasmas){
				
			unFantasma.setObjetivo(Objetivo.atrapar());
		}
		
	}


	private void reestablecerTablero() {
		this.tablero.restablecerSemillasRestantes();
		this.reestablecerPosicionPersonajes();
		Punto dimension = this.tablero.getDimension();
		
		for (int x = 0; x < dimension.getPuntoX(); x++){
			for (int y = 0; y < dimension.getPuntoY(); y++){
				Casillero casillero = this.tablero.getCasillero(new Punto(x,y));
				casillero.setFuePisado(false);
			}
		}
	}
	
	private void reestablecerPosicionPersonajes(){
		Pacman pacman = this.tablero.getPacman();
		pacman.setPosicion(pacman.getPosicionInicial());
		
		for( Fantasma fant : this.tablero.getFantasmas()){
			fant.volverACasa();
		}
	}


	public int getNivel(){
		return this.nivel;
	}
	
	public static Juego getInstancia(){
		return instancia;
	}
	
	public void reiniciarJuego(){
		estadoJuego = EstadosJuego.EN_CURSO;
		this.reestablecerTablero();
		this.reestablecerDatos();
	}


	private void reestablecerDatos() {
		this.nivel = 1;
		this.jugador.resetearPuntos();
		this.jugador.resetearVidas();
	}


	public Jugador getJugador(){  
		return this.jugador; 
	}

	
	public EstadosJuego getEstado(){
		return Juego.estadoJuego;
	}


	public Tablero getTablero() {
		return this.tablero;
	}

	
	public void aumentarDificultad(){
	
		Collection<Fantasma> fantasmas = this.tablero.getFantasmas();
		for(Fantasma unFantasma : fantasmas){
			
			unFantasma.aumentarVelocidad();
		}
		
		PuntoDePoder.cambiarDuracion();
	}


	public int getCantNiveles() {
		return cantidadDeNiveles;
	}
}
