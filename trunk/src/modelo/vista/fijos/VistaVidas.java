package modelo.vista.fijos;

import java.awt.Graphics;

import modelo.fijos.Juego;
import modelo.fijos.Punto;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaVidas extends Imagen{

	public VistaVidas(){
		String nombreArchivoImagen = "pacman.JPG";
		setNombreArchivoImagen(nombreArchivoImagen);
		Punto posicionVidas = new Punto (23*25, 12*25);
		setPosicionable(posicionVidas);
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		int vidas = Juego.getInstancia().getJugador().getCantVidas();
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		for (int i = 1; i <= vidas; i++){
			grafico.drawImage(super.getImagen(), super.getPosicionable().getX(), 
					super.getPosicionable().getY() + i*25, null);
		}
	}
	
}
