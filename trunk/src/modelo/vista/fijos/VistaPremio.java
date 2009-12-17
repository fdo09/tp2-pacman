package modelo.vista.fijos;

import java.awt.Graphics;

import modelo.fijos.Casillero;
import modelo.fijos.Punto;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public abstract class VistaPremio extends Imagen{
	
	private Casillero premio;
	
	
	public VistaPremio(Casillero premioActual, Punto posicion) {
		this.premio = premioActual;
		this.setPosicionable(posicion);
	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		if (! (this.premio.fuePisado()) ){
			Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
			grafico.drawImage(super.getImagen(), super.getPosicionable().getX(), super.getPosicionable().getY(), null);
		}
	}
	

}
