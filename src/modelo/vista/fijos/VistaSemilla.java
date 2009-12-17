package modelo.vista.fijos;

import java.awt.Color;
import java.awt.Graphics;

import modelo.fijos.Casillero;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Circulo;


public class VistaSemilla extends Circulo {
	
	private Casillero semilla;

	public VistaSemilla(Casillero semilla) {
		super(12);
		this.semilla = semilla;
		setColor(Color.WHITE);
	}
	
	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = (Graphics)superfice.getBuffer();
		if (this.semilla.fuePisado())
			grafico.setColor(Color.BLACK);
		else
			grafico.setColor(Color.WHITE);
		grafico.fillOval(getPosicionable().getX() , getPosicionable().getY(), 12, 12);
	}

}
