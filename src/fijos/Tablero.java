package fijos;


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
	ArrayList<Personaje> fantasmas;
	Casillero casilla;
	Personaje pac;
	Punto nuevo;
	
	public Tablero (int base, int altura, Collection<Integer> casilleros){
		//Capacidad inicial es base*altura+1 para prevenir que no se llene el HashMap. 
		//Ya q se si se llena se tiene que volver a agrandar y eso consume bastantes recursos.
		this.casilleros = new HashMap<Punto, Casillero>(base*altura+1, 1);
		this.fantasmas = new ArrayList<Personaje>();
	}

	public Punto posicionPac() {
		// TODO Un metodo que devuelva la posicion del pac.
		return null;
	}
	
	public void addCasillero(Punto punto, Casillero nuevo){
		//agrega un casillero con una ubicacion
		this.casilleros.put(punto, nuevo);
	}

	public Collection<Punto> getCasa() {
		// TODO Un metodo que devuelva una coleccion con todas las posiciones de la casa.
		return null;
	}

	public Casillero getCasillero(Punto punto) {
		// TODO Un metodo que dado un punto me devuelva el casillero en esa posicion
		return this.casilleros.get(punto);
	}

	
	public boolean esValida(Punto unaPosicion) {
		//INCLUYE LAS PAREDES FRONTERA SI ?
		return false;
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
