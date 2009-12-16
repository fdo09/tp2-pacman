package modelo.fijos;

import modelo.vista.control.CargaVistaTablero;
import modelo.vista.control.VistaMensaje;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;

public class AdministradorJuego implements ObjetoVivo{
	
	private Tablero tablero;
	private ControladorJuego controlador;
	
	public AdministradorJuego(ControladorJuego controlador){
		this.tablero = Juego.getInstancia().getTablero();
		this.controlador = controlador;
	}

	public void vivir() {
		this.controlarNivel();
		
	}

	private void controlarNivel() {
		if (this.tablero.getSemillasRestantes() == 0){
			VistaMensaje nuevoNivel = new VistaMensaje("Felicidades ha avanzado de nivel");
			controlador.agregarDibujable(nuevoNivel);
			Juego.getInstancia().aumentarNivel();
		}
		
	}

}