package fijos;

import modelo.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modelo.Personaje;


public class Tablero {
	
	HashMap<Punto, Casillero> casilleros;
	ArrayList<Fantasma> fantasmas;
	Pacman pacman;
	Punto casa;
	Casillero casilla;
	Punto nuevo;
	
	public Tablero (int base, int altura, Collection<Integer> casilleros){
		//Capacidad inicial es base*altura+1 para prevenir que no se llene el HashMap. 
		//Ya q se si se llena se tiene que volver a agrandar y eso consume bastantes recursos.
		this.casilleros = new HashMap<Punto, Casillero>(base*altura+1, 1);
		this.fantasmas = new ArrayList<Fantasma>();
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
	
	
	public void cargaTablero (File file){
		
		try {
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeLst = doc.getElementsByTagName("fila");
			for ( int s = 0; s < nodeLst.getLength(); s++){
				Node fstNode = nodeLst.item(s);
				if ( fstNode.getNodeType() == Node.ELEMENT_NODE){
					
					Element fstElmnt = (Element) fstNode;
					NodeList fstNmElemLst = fstElmnt.getElementsByTagName("casillero");
					for ( int i = 0; i < fstNmElemLst.getLength(); i++){
						Element fir = (Element) fstNmElemLst.item(i);
						NodeList fstNm = fir.getChildNodes();
						nuevo = new Punto(s, i);
						String tipoDeCasillero = ((Node)fstNm.item(0)).getNodeValue();
						if ( tipoDeCasillero == "Semilla"){
							casilla = new Semilla(nuevo);
						}else if (tipoDeCasillero == "Pared"){
							casilla = new Pared(nuevo);
						}else {
							casilla = new PuntoDePoder(nuevo);
						}
						this.addCasillero(nuevo, casilla);
						// System.out.println("Punto X = " + s +" Punto Y = "+ i + " Casillero = " + ((Node)fstNm.item(0)).getNodeValue());
					}
			   }
	    	}		
		}
		catch(Exception e){
			System.out.println ("Error al procesar el fichero de favoritos: " + e.getMessage());
		    e.printStackTrace();
		
		}		
		
	
	
	
	}

	

	public ArrayList<Punto> obtenerPosicionesDeFantasmas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
