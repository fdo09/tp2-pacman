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
			
			Juego.cambiarEstadoDelJuego(EstadosJuego.GANADO);
			VistaMensaje nuevoNivel = new VistaMensaje("Felicidades ha avanzado de nivel");
			controlador.agregarDibujable(nuevoNivel);		
			Juego.getInstancia().aumentarNivel();
		}
			
	}
	
	
	public void controlarVidas(){
		
		if(Juego.getInstancia().getJugador().getCantVidas() == 0){
			Juego.cambiarEstadoDelJuego(EstadosJuego.PERDIDO);
			controlador.detenerJuego();
			VistaJuegoPerdido juegoPerdido = new VistaJuegoPerdido(this.ventana);
			VistaReiniciarJuego reiniciar = new VistaReiniciarJuego(this.ventana, this.controlador);
		}
	}
}
