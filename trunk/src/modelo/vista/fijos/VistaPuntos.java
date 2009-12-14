package modelo.vista.fijos;

import java.awt.Color;
import java.awt.Font;

import modelo.fijos.Juego;
import modelo.fijos.Punto;
import ar.uba.fi.algo3.titiritero.vista.Texto;

public class VistaPuntos extends Texto {

	public VistaPuntos(){
		super();
		Punto posicion = new Punto(2*25 , 26*25);
		setPosicionable(posicion);
		setFuente(Font.MONOSPACED, 14);
	}
	
	
	protected String getTexto() {
		Integer puntos = Juego.getInstancia().getJugador().getPuntos();
		String lineaPuntos = "Puntos: \n";
		String stringPuntos = puntos.toString();
		lineaPuntos = lineaPuntos.concat(stringPuntos);
		return lineaPuntos;
	}

}
