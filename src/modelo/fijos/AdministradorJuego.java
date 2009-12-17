package modelo.fijos;

import modelo.vista.control.VentanaPrincipal;
import modelo.vista.control.VistaJuegoPerdido;
import modelo.vista.control.VistaMensaje;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;



public class AdministradorJuego implements ObjetoVivo{
	
	private Tablero tablero;
	private ControladorJuego controlador;
	private VentanaPrincipal ventana;
	
	public AdministradorJuego(ControladorJuego controlador, VentanaPrincipal ventana){
		this.tablero = Juego.getInstancia().getTablero();
		this.controlador = controlador;
		this.ventana = ventana;
	}

	
	public void vivir() {
		this.controlarNivel();
		this.controlarVidas();
		
	}

	
	private void controlarNivel() {
		
		if (this.tablero.getSemillasRestantes() == 0){
			
			
			VistaMensaje nuevoNivel = new VistaMensaje("Felicidades ha avanzado de nivel");
			controlador.agregarDibujable(nuevoNivel);		
			Juego.getInstancia().aumentarNivel();
			
			int nivelFinal = 4;
			
			if(Juego.getInstancia().getNivel() == nivelFinal){
				
				Juego.cambiarEstadoDelJuego(EstadosJuego.GANADO);
				
				@SuppressWarnings("unused")//Al instanciar se muestra en pantalla.
				VistaJuegoGanado juegoGanado = new VistaJuegoGanado(this.ventana);
				
				@SuppressWarnings("unused")//Al instanciar se muestra en pantalla.
				VistaReiniciarJuego reiniciar = new VistaReiniciarJuego(this.ventana, this.controlador);
			}
		}
			
	}
	
	
	public void controlarVidas(){
		
		if(Juego.getInstancia().getJugador().getCantVidas() == 0){
			Juego.cambiarEstadoDelJuego(EstadosJuego.PERDIDO);
			controlador.detenerJuego();
			
			
			@SuppressWarnings("unused")//Al instanciar se muestra en pantalla.
			VistaJuegoPerdido juegoPerdido = new VistaJuegoPerdido(this.ventana);
			
			@SuppressWarnings("unused")////Al instanciar se muestra en pantalla.
			VistaReiniciarJuego reiniciar = new VistaReiniciarJuego(this.ventana, this.controlador);
		}
	}
}
