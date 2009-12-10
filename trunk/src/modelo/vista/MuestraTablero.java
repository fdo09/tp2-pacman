package modelo.vista;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import modelo.fijos.Casa;
import modelo.fijos.Casillero;
import modelo.fijos.Pared;
import modelo.fijos.Punto;
import modelo.fijos.PuntoDePoder;
import modelo.fijos.Semilla;
import modelo.fijos.Tablero;
import modelo.moviles.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class MuestraTablero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Instanciamos
		Tablero tablero;
		PosicionTablero unTablero = new PosicionTablero(800,800);
		ControladorJuego controlador = new ControladorJuego();
	
		VentanaPrincipal ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana.getSuperficieDeDibujo());
		ventana.setVisible(true);
		VistaTablero vistaTablero = new VistaTablero();
		vistaTablero.setPosicionable(unTablero);

		controlador.agregarDibujable(vistaTablero);
		Casillero casilleroAux = null;
		Punto posicion;
		tablero = new Tablero(32,32);
		
		File file = new File("xml/Tablero.xml");
		try {
			
			int n = 0;
			int r = 0;
			int s = 0;
			int i = 0;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeLst = doc.getElementsByTagName("fila");
			for ( s = 0; s < nodeLst.getLength(); s++){
				Node fstNode = nodeLst.item(s);
				if ( fstNode.getNodeType() == Node.ELEMENT_NODE){
					
					Element fstElmnt = (Element) fstNode;
					NodeList fstNmElemLst = fstElmnt.getElementsByTagName("casillero");
					r = 0;
					for ( i = 0; i < fstNmElemLst.getLength(); i++){
						
						Element fir = (Element) fstNmElemLst.item(i);
						NodeList fstNm = fir.getChildNodes();
						String tipoDeCasillero = ((Node)fstNm.item(0)).getNodeValue();
						posicion = new Punto(i, s);
						PosicionCasillero cas$i = new PosicionCasillero(r,n);
						VistaCasillero vis$i = new VistaCasillero();
						if ( tipoDeCasillero.equals("semilla")){
							
							vis$i.setColor(Color.CYAN);
							
							serVisible(controlador, cas$i, vis$i);
							
							VistaSemilla vistaSemilla = new VistaSemilla();
							vistaSemilla.setPosicionable(cas$i);
							controlador.agregarDibujable(vistaSemilla);
							casilleroAux = new Semilla(posicion, tablero);
							
											
							
							
						}else if (tipoDeCasillero.equals("pared")){
							
							vis$i.setColor(Color.BLUE);
							serVisible(controlador, cas$i, vis$i);
							casilleroAux = new Pared(posicion, tablero);
						
							
						}else if (tipoDeCasillero.equals("casa")){
							
							vis$i.setColor(Color.GREEN);
							serVisible(controlador, cas$i, vis$i);
							casilleroAux = new Casa(posicion, tablero);
							tablero.agregarCasa(posicion);
							
														
						}else if (tipoDeCasillero.equals("PuntoDePoder")){
							
							vis$i.setColor(Color.CYAN);
							
							serVisible(controlador, cas$i, vis$i);
							
							VistaPuntoDePoder vistaPuntoDePoder = new VistaPuntoDePoder();
							vistaPuntoDePoder.setPosicionable(cas$i);
							controlador.agregarDibujable(vistaPuntoDePoder);
							casilleroAux = new PuntoDePoder(posicion,tablero);
							
							
						}
						
						tablero.addCasillero(posicion, casilleroAux);
						// System.out.println("Punto X = " + s +" Punto Y = "+ i + " Casillero = " + ((Node)fstNm.item(0)).getNodeValue());
						// System.out.println(tab.esTransitable(nuevo));
						// if ( r == 1){ r = 25;}
						// else {	r = r + 25; }
						r = r + 25;
					}
			   }
			  n = n + 25;
	    	}
		Punto nuevaDimension = new Punto(s, i);
		tablero.setDimension(nuevaDimension);
			
		}
		catch(Exception e){
			System.out.println ("Error al procesar el fichero de favoritos: " + e.getMessage());
		    e.printStackTrace();
		
		}
		Punto puntoPacman = new Punto(15,21);
		Pacman pacman = new Pacman(tablero, puntoPacman);
		VistaPacman vistaPacman = new VistaPacman();
		vistaPacman.setPosicionable(pacman);
		tablero.addPacman(pacman);
		
		tablero.cargarPersonajes();
		
		ArrayList<Fantasma> fantasmas = tablero.getFantasmas();
		for(Fantasma f : fantasmas){
			if(f.getClass().equals(FantasmaRojo.class)){
				VistaFantasmaRojo vistaRojo = new VistaFantasmaRojo();
				vistaRojo.setPosicionable(f);
				controlador.agregarDibujable(vistaRojo);
			}
			else if(f.getClass().equals(FantasmaAmarillo.class)){
				VistaFantasmaAmarillo vistaAmarillo = new VistaFantasmaAmarillo();
			    vistaAmarillo.setPosicionable(f);
			    controlador.agregarDibujable(vistaAmarillo);
			}
			else if(f.getClass().equals(FantasmaInmune.class)){
				VistaFantasmaInmune vistaInmune = new VistaFantasmaInmune();
			    vistaInmune.setPosicionable(f);
			    controlador.agregarDibujable(vistaInmune);
			}
			else if(f.getClass().equals(FantasmaNaranja.class)){
				VistaFantasmaNaranja vistaNaranja = new VistaFantasmaNaranja();
				vistaNaranja.setPosicionable(f);
				controlador.agregarDibujable(vistaNaranja);
			}
			else if(f.getClass().equals(FantasmaAzul.class)){
				VistaFantasmaAzul vistaAzul = new VistaFantasmaAzul();
				vistaAzul.setPosicionable(f);
				controlador.agregarDibujable(vistaAzul);
			}
			controlador.agregarObjetoVivo(f);
		
		}
		
		/*
		// Un Fantasma Rojo
		Punto ubicacionRojo = new Punto(26,1);
		FantasmaRojo fantasmaRojo = new FantasmaRojo(tablero, ubicacionRojo);
		VistaFantasmaRojo vistaRojo = new VistaFantasmaRojo();
		vistaRojo.setPosicionable(fantasmaRojo);
		tablero.addFantasma(fantasmaRojo);
		
		// Un Fantasma Amarillo
		Punto ubicacionAmarillo = new Punto(2,1);
		FantasmaAmarillo fantasmaAmarillo = new FantasmaAmarillo(tablero, ubicacionAmarillo);
		VistaFantasmaAmarillo vistaAmarillo = new VistaFantasmaAmarillo();
	    vistaAmarillo.setPosicionable(fantasmaAmarillo);
	    tablero.addFantasma(fantasmaAmarillo);
		
	    //Un Fantasma Inmune
		Punto ubicacionInmune = new Punto(20,21);
		FantasmaInmune fantasmaInmune = new FantasmaInmune(tablero, ubicacionInmune);
		VistaFantasmaInmune vistaInmune = new VistaFantasmaInmune();
		vistaInmune.setPosicionable(fantasmaInmune);
		tablero.addFantasma(fantasmaInmune);
	    
	    // Un Fantasma Naranja
		Punto ubicacionNaranja = new Punto(6,1);
		FantasmaNaranja fantasmaNaranja = new FantasmaNaranja(tablero, ubicacionNaranja);
		VistaFantasmaNaranja vistaNaranja = new VistaFantasmaNaranja();
		vistaNaranja.setPosicionable(fantasmaNaranja);
		tablero.addFantasma(fantasmaNaranja);
	    
	 // Un Fantasma Azul
		Punto ubicacionAzul = new Punto(12,11);
		FantasmaAzul fantasmaAzul = new FantasmaAzul(tablero, ubicacionAzul);
		VistaFantasmaAzul vistaAzul = new VistaFantasmaAzul();
		vistaAzul.setPosicionable(fantasmaAzul);
		tablero.addFantasma(fantasmaAzul);
		*/
	    
		controlador.agregarObjetoVivo(pacman);
		/*
		controlador.agregarObjetoVivo(fantasmaRojo);
		controlador.agregarObjetoVivo(fantasmaAmarillo);
		controlador.agregarObjetoVivo(fantasmaInmune);
		controlador.agregarObjetoVivo(fantasmaNaranja);
		controlador.agregarObjetoVivo(fantasmaAzul);
		*/
		
		
		controlador.agregarDibujable(vistaPacman);
		/*
		controlador.agregarDibujable(vistaRojo);
		controlador.agregarDibujable(vistaAmarillo);
		controlador.agregarDibujable(vistaInmune);
		controlador.agregarDibujable(vistaNaranja);
		controlador.agregarDibujable(vistaAzul);
		*/
				
		controlador.agregarMouseClickObservador(vistaTablero);
		
		
		controlador.setIntervaloSimulacion(300);
		controlador.comenzarJuego();
		
		
		
	}

	private static void serVisible(ControladorJuego controlador,
			PosicionCasillero cas$i, VistaCasillero vis$i) {
		vis$i.setPosicionable(cas$i);
		controlador.agregarDibujable(vis$i);
	}

}
