package modelo.fijos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAmarillo;
import modelo.moviles.FantasmaAzul;
import modelo.moviles.FantasmaInmune;
import modelo.moviles.FantasmaNaranja;
import modelo.moviles.FantasmaRojo;
import modelo.moviles.Pacman;


public class Tablero {
	
	private HashMap<Punto, Casillero> casilleros;
	private ArrayList<Fantasma> fantasmas;
	private Pacman pacman;
	private Punto casa;
	private Punto inicioPacman;
	private Punto dimension;

	      
	public Tablero (int base, int altura){
		//Capacidad inicial es base*altura+1 para prevenir que no se llene el HashMap. 
		//Ya q se si se llena se tiene que volver a agrandar y eso consume bastantes recursos.
		this.casilleros = new HashMap<Punto, Casillero>(base*altura+1, 1);
		this.fantasmas = new ArrayList<Fantasma>();
		
		this.cargarPersonajes();
	}
	
	private void cargarPersonajes() {
		this.fantasmas.add(new FantasmaRojo(this, casa));
		this.fantasmas.add(new FantasmaAmarillo(this, casa));
		this.fantasmas.add(new FantasmaNaranja(this, casa));
		this.fantasmas.add(new FantasmaAzul(this, casa));
		this.fantasmas.add(new FantasmaInmune(this, casa));
		this.pacman = new Pacman(this, this.inicioPacman);
	}

	public boolean estaVacio(){
		return this.casilleros.isEmpty();
	}
	
	public void addFantasma(Fantasma fantasma){
		this.fantasmas.add(fantasma);
	}
	
	public Punto posicionFantasma(Fantasma fantasma){
		Fantasma nuevoFantasma;
		Iterator<Fantasma> f = fantasmas.iterator();
		while (f.hasNext()){
			nuevoFantasma = f.next();
				if (nuevoFantasma == fantasma){
					return fantasma.getPosicion();
				}
		    }
		return null;
		
	}
	
	public void addPacman(Pacman pacman){
		this.pacman = pacman;
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
	
	public ArrayList<Fantasma> obtenerFantasmas(){
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
	
	
	

	public LinkedList<Punto> obtenerPosicionesDeFantasmas() {
		
		LinkedList<Punto> posicionesDeFantasmas = new LinkedList<Punto>();
		
		for(Fantasma unFantasma : this.fantasmas ){
			
			posicionesDeFantasmas.add(unFantasma.getPosicion());
			
					
		}
		return posicionesDeFantasmas;
	}
	public Punto obtenerDimension() {
		return this.dimension;
	}
	
	
}
