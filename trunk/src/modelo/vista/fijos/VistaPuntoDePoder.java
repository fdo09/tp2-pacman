package modelo.vista.fijos;

import java.awt.Color;
import java.awt.Graphics;

import modelo.fijos.Casillero;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Circulo;


public class VistaPuntoDePoder extends Circulo {

	private Casillero ptoPoder;
	
	public VistaPuntoDePoder(Casillero ptoPoder) {
		super(15);
		setColor(Color.YELLOW);
		this.ptoPoder = ptoPoder;
	}
	
	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = (Graphics)superfice.getBuffer();
		if (this.ptoPoder.fuePisado())
			grafico.setColor(Color.BLACK);
		else
			grafico.setColor(Color.YELLOW);
		grafico.fillOval(getPosicionable().getX() , getPosicionable().getY(), 15, 15);
	}

}