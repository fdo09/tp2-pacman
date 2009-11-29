package fijos;

import modelo.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


import modelo.Personaje;


public class Tablero {
	
	HashMap<Punto, Casillero> casilleros;
	ArrayList<Fantasma> fantasmas;
	Pacman pacman;
	Punto casa;
	Punto dimension;
	Casillero casilla;
	Punto nuevo;
	      
	public Tablero (int base, int altura){
		//Capacidad inicial es base*altura+1 para prevenir que no se llene el HashMap. 
		//Ya q se si se llena se tiene que volver a agrandar y eso consume bastantes recursos.
		this.casilleros = new HashMap<Punto, Casillero>(base*altura+1, 1);
		this.fantasmas = new ArrayList<Fantasma>();
	}
	// Lo hago de prueba Marcelo
	public Tablero(){
		
	}
	
	public boolean estaVacio(){
		return this.casilleros.isEmpty();
	}
	public Pacman obtenerPacman() {
		return this.pacman;
	}
	
	public void addCasillero(Punto punto, Casillero nuevo){
		//agrega un casillero con una ubicacion
		this.casilleros.put(punto, nuevo);
	}

	public Punto obtenerCasa() {
		return casa;
	}

	public Casillero getCasillero(Punto punto) {
		return this.casilleros.get(punto);
	}
	
	public Collection<Fantasma> obtenerFantasmas(){
		return this.fantasmas;
	}

	
	public boolean esTransitable(Punto unaPosicion) {
		Casillero casillero = this.casilleros.get(unaPosicion);
		return casillero.transitable();
	}
	
	
	public Collection<Punto> obtenerAdjacentesValidos(Punto centro){
		Collection<Punto> adjacentes = centro.obtenerPuntosAdyacentes();
		Collection<Punto> adjacentesValidos = new ArrayList<Punto>();
		for(Punto punto : adjacentes){
			if (esTransitable(punto))
				adjacentesValidos.add(punto);
		}
		return adjacentesValidos;
	}
	
	
	

	public ArrayList<Punto> obtenerPosicionesDeFantasmas() {
		// TODO Auto-generated method stub
		return null;
	}
	public Punto obtenerDimension() {
		return this.dimension;
	}
	
	
}
