package modelo.fijos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import modelo.excepciones.*;
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
	private LinkedList<Punto> casas;
	private Punto dimension;
	private int semillasRestantes;
	private int semillasIniciales;

	      
	public Tablero (int base, int altura){
		//Capacidad inicial es base*altura+1 para prevenir que no se llene el HashMap. 
		//Ya q se si se llena se tiene que volver a agrandar y eso consume bastantes recursos.
		this.casilleros = new HashMap<Punto, Casillero>(base*altura+1, 1);
		this.fantasmas = new ArrayList<Fantasma>();
		this.semillasRestantes = 0;
		this.semillasIniciales = 0;
		this.casas = new LinkedList<Punto>();
	}
	
	public void cargarPersonajes() {
		Punto casaRojo = this.getUnaCasaVacia();
		this.addFantasma(new FantasmaRojo(this, casaRojo.getPosicion(),3));
		
		Punto casaAmarillo = this.getUnaCasaVacia();
		this.addFantasma(new FantasmaAmarillo(this, casaAmarillo.getPosicion(),3));
		
		Punto casaNaranja = this.getUnaCasaVacia();
		this.addFantasma(new FantasmaNaranja(this, casaNaranja.getPosicion(), 3));
		
		Punto casaAzul = this.getUnaCasaVacia();
		this.addFantasma(new FantasmaAzul(this, casaAzul.getPosicion(),3));
		
		Punto casaImune = this.getUnaCasaVacia();
		this.addFantasma(new FantasmaInmune(this, casaImune.getPosicion(),2));
	}
	
	
	public Punto getUnaCasaVacia(){
		try {
			return this.casas.pop();
		} catch (NoSuchElementException e) {
			throw new CasasLlenasException();
		}
	}
	

	public boolean estaVacio(){
		return this.casilleros.isEmpty();
	}
	
	
	public void addFantasma(Fantasma fantasma){
			this.fantasmas.add(fantasma);
	}

	
	public void addPacman(Pacman pacman){
		if(!this.esTransitable(pacman.getPosicion())){
			throw new RuntimeException("La posicion de inicio del pacman es invalida");
		}
		this.pacman = pacman;
	}
	
	
	public Pacman getPacman() {
		return this.pacman;
	}
	
	
	public void addCasillero(Punto punto, Casillero nuevo){
		this.casilleros.put(punto, nuevo);
	}
	

	public Casillero getCasillero(Punto punto) {
		return this.casilleros.get(punto);
	}
	
	
	public ArrayList<Fantasma> getFantasmas(){
		return this.fantasmas;
	}

	
	public boolean esTransitable(Punto unaPosicion) {
		Casillero casillero = this.casilleros.get(unaPosicion);
		return casillero.transitable();
	}
	
	
	public Collection<Punto> getAdjacentesValidos(Punto centro){
		
		Collection<Punto> adjacentes = centro.getPuntosAdyacentes();
		Collection<Punto> adjacentesValidos = new ArrayList<Punto>();
		for(Punto punto : adjacentes){
			
			if (esTransitable(punto))
				adjacentesValidos.add(punto);
		}
		return adjacentesValidos;
	}
	

	public LinkedList<Punto> getPosicionesDeFantasmas() {
		
		LinkedList<Punto> posicionesDeFantasmas = new LinkedList<Punto>();
		
		for(Fantasma unFantasma : this.fantasmas ){
			posicionesDeFantasmas.add(unFantasma.getPosicion());
			
		}
		return posicionesDeFantasmas;
	}
	
	
	public Punto getDimension() {
		return this.dimension;
	}
	
	
	public void setDimension(Punto nuevaDimension){
		this.dimension = nuevaDimension;
	}

	
	public void agregarCasa (Punto nuevaCasa){
		this.casas.push(nuevaCasa);
	}
	
	
	public int getSemillasRestantes() {
		return this.semillasRestantes;
	}
	
	public void restablecerSemillasRestantes(){
		this.semillasRestantes = this.semillasIniciales;
	}

	
	public void aumentarSemilla() {
		this.semillasRestantes += 1;
		this.semillasIniciales += 1;
	}

	
	public void restarSemilla() {
		this.semillasRestantes -= 1;
	}
	
	
}
