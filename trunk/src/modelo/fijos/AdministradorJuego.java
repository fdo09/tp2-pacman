package modelo.fijos;

import modelo.vista.control.VentanaPrincipal;
import modelo.vista.control.VistaJuegoGanado;
import modelo.vista.control.VistaJuegoPerdido;
import modelo.vista.control.VistaMensajeNuevoNivel;
import modelo.vista.fijos.VistaReiniciarJuego;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;



public class AdministradorJuego implements ObjetoVivo{
	
	private Tablero tablero;
	private ControladorJuego controlador;
	private VentanaPrincipal ventana;
	private ControladorPremios controladorPremios;
	
	public AdministradorJuego(ControladorJuego controlador, VentanaPrincipal ventana){
		this.tablero = Juego.getInstancia().getTablero();
		this.controlador = controlador;
		this.ventana = ventana;
		this.controladorPremios = new ControladorPremios();
	}

	
	public void vivir() {
		this.controlarNivel();
		this.controlarVidas();
		this.controlarPremios();
	}

	
	private void controlarNivel() {

		
		if (this.tablero.getSemillasRestantes() == 0){
			
			Juego.getInstancia().aumentarNivel();
			
			int nivelFinal = Juego.getInstancia().getCantNiveles();
			
			if(Juego.getInstancia().getNivel() == nivelFinal){
				
				Juego.setEstadoDelJuego(EstadosJuego.GANADO);
				
				@SuppressWarnings("unused")//Al instanciar se muestra en pantalla.
				VistaJuegoGanado juegoGanado = new VistaJuegoGanado(this.ventana);
				
				@SuppressWarnings("unused")//Al instanciar se muestra en pantalla.
				VistaReiniciarJuego reiniciar = new VistaReiniciarJuego(this.ventana, this.controlador);
			}
			else{
				@SuppressWarnings("unused")//Al instanciar se abre automaticamente la ventana.
				
				VistaMensajeNuevoNivel nuevoNivel = new VistaMensajeNuevoNivel(this.ventana);
			}
		}
			
	}
	
	
	public void controlarVidas(){
		
		if(Juego.getInstancia().getJugador().getCantVidas() == 0){
			Juego.setEstadoDelJuego(EstadosJuego.PERDIDO);
			controlador.detenerJuego();
			
			@SuppressWarnings("unused")//Al instanciar se muestra en pantalla.
			VistaJuegoPerdido juegoPerdido = new VistaJuegoPerdido(this.ventana);
			
			@SuppressWarnings("unused")////Al instanciar se muestra en pantalla.
			VistaReiniciarJuego reiniciar = new VistaReiniciarJuego(this.ventana, this.controlador);
		}
	}
	
	public void controlarPremios(){
		this.controladorPremios.controlar();
	}
}
