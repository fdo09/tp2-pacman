package modelo.vista.control;

import java.awt.Color;
import java.awt.Font;

import modelo.fijos.Juego;
import modelo.fijos.Punto;

import ar.uba.fi.algo3.titiritero.vista.Imagen;
import ar.uba.fi.algo3.titiritero.vista.Texto;
import ar.uba.fi.algo3.titiritero.vista.TextoDinamico;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;

public class VistaMensaje extends TextoEstatico{
	
	public VistaMensaje(String mensaje){
		super(mensaje);
		setPosicionable(new Punto (10*25, 26*25));
	}
	

}
