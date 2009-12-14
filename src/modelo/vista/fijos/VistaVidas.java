package modelo.vista.fijos;

import java.awt.Graphics;

import modelo.fijos.Juego;
import modelo.fijos.Punto;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;
import ar.uba.fi.algo3.titiritero.vista.Texto;

public class VistaVidas extends Imagen{
	
	private Texto texto;

	public VistaVidas(){
		String nombreArchivoImagen = "pacmanDerecha.JPG";
		setNombreArchivoImagen(nombreArchivoImagen);
		Punto posicionVidas = new Punto (20*25, 26*25);
		setPosicionable(posicionVidas);
		
		this.texto = new Texto(){

			@Override
			protected String getTexto() {
				return "Vidas";
			}
		};
		this.texto.setPosicionable(new Punto(21*25, 26*25));
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		int vidas = Juego.getInstancia().getJugador().getCantVidas();
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		for (int i = 1; i <= vidas; i++){
			grafico.drawImage(super.getImagen(), super.getPosicionable().getX() + i*25, 
					super.getPosicionable().getY(), null);
		}
		this.texto.dibujar(superficeDeDibujo);
	}
	
}
