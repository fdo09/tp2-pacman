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
	private ArrayList<Punto> casas;
	private Punto inicioPacman;
	private Punto dimension;
	private int semillasRestantes;

	      
	public Tablero (int base, int altura){
		//Capacidad inicial es base*altura+1 para prevenir que no se llene el HashMap. 
		//Ya q se si se llena se tiene que volver a agrandar y eso consume bastantes recursos.
		this.casilleros = new HashMap<Punto, Casillero>(base*altura+1, 1);
		this.fantasmas = new ArrayList<Fantasma>();
		this.semillasRestantes = 0;
		this.casas = new ArrayList<Punto>();
	}
	
	public void cargarPersonajes() {
		Punto puntoAux = new Punto (0,0);
		this.addFantasma(new FantasmaRojo(this, puntoAux));
		this.addFantasma(new FantasmaAmarillo(this, puntoAux));
		this.addFantasma(new FantasmaNaranja(this, puntoAux));
		this.addFantasma(new FantasmaAzul(this, puntoAux));
		this.addFantasma(new FantasmaInmune(this, puntoAux));
		this.addPacman(new Pacman(this, this.inicioPacman));
	}

	public boolean estaVacio(){
		return this.casilleros.isEmpty();
	}
	
	public void addFantasma(Fantasma fantasma){
		for(Punto posicionCasa : casas){
			Casa casa = (Casa) this.casilleros.get(posicionCasa);
			if(casa.isOcupada()){
				fantasma.setPosicion(posicionCasa);
				this.fantasmas.add(fantasma);
				return;
			}
			
		}
		throw new CasasLlenasException();
	}

	
	public void addPacman(Pacman pacman){
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
		this.casas.add(nuevaCasa);
	}
	
	public int getSemillasRestantes() {
		return this.semillasRestantes;
	}

	public void setSemillasRestantes(int semillasRestantes) {
		this.semillasRestantes = semillasRestantes;
	}

	public void restarSemilla() {
		this.semillasRestantes -= 1;
	}
	
	
}
