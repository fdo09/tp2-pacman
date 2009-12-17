package modelo.vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.vista.control.Integrante;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class PosicionTablero implements Posicionable, Iterable<Integrante>{

private int alto;
private int ancho;
private List<Integrante> integrantes;

	public PosicionTablero(int alto, int ancho){
		this.alto = alto;
		this.ancho = ancho;
		this.integrantes = new ArrayList<Integrante>();
	}

	public int getX() {
		
		return 0;
	}

	public int getY() {
		
		return 0;
	}

	public Iterator<Integrante> iterator() {
	
		return this.integrantes.iterator();
	}
	
	public void agregarIntegrante(Integrante integrante){
		     this.integrantes.add(integrante);
	}
	
	public void setAlto(int alto){
		this.alto = alto;
	}
	
	public void setAncho(int ancho){
		this.ancho = ancho;
	}
	
	public int getAlto(){
		return this.alto;
	}
	
	public int getAncho(){
		return this.ancho;
	}
	
	
}
