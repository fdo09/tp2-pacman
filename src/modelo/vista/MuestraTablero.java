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
import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAmarillo;
import modelo.moviles.FantasmaAzul;
import modelo.moviles.FantasmaInmune;
import modelo.moviles.FantasmaNaranja;
import modelo.moviles.FantasmaRojo;
import modelo.moviles.Pacman;
import modelo.vista.control.EscuchadorDeKeyPress;
import modelo.vista.control.VentanaPrincipal;
import modelo.vista.fijos.PosicionCasillero;
import modelo.vista.fijos.VistaCasillero;
import modelo.vista.fijos.VistaPuntoDePoder;
import modelo.vista.fijos.VistaSemilla;
import modelo.vista.moviles.VistaFantasmaAmarillo;
import modelo.vista.moviles.VistaFantasmaAzul;
import modelo.vista.moviles.VistaFantasmaInmune;
import modelo.vista.moviles.VistaFantasmaNaranja;
import modelo.vista.moviles.VistaFantasmaRojo;
import modelo.vista.moviles.VistaPacman;

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
		
		ControladorJuego controlador = new ControladorJuego();
		
		Tablero tablero;
		tablero = new Tablero(32,32);
		
		Punto puntoPacman = new Punto(15,21);
		Pacman pacman = new Pacman(tablero, puntoPacman);
		controlador.agregarKeyPressObservador(new EscuchadorDeKeyPress(pacman));
		
		VentanaPrincipal ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana.getSuperficieDeDibujo());
		ventana.setVisible(true);
		
			
	
		generarVistaDeCasilleros(controlador, tablero);
		
		VistaPacman vistaPacman = getVistaPacman(tablero, pacman);
		
		tablero.cargarPersonajes();
		
		generarVistaDeFantasmas(controlador, tablero);
		
		    
		controlador.agregarObjetoVivo(pacman);
		controlador.agregarDibujable(vistaPacman);
		controlador.setIntervaloSimulacion(300);
		controlador.comenzarJuego();
		
		
		
	}

	private static void generarVistaDeFantasmas(ControladorJuego controlador,
			Tablero tablero) {
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
	}

	private static VistaPacman getVistaPacman(Tablero tablero, Pacman pacman) {
		VistaPacman vistaPacman = new VistaPacman();
		vistaPacman.setPosicionable(pacman);
		tablero.addPacman(pacman);
		return vistaPacman;
	}

	private static void generarVistaDeCasilleros(ControladorJuego controlador,
			Tablero tablero) {
		Casillero casilleroAux = null;
		Punto posicion;
		
		
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
							
							vis$i.setColor(Color.BLACK);
							
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
							
							vis$i.setColor(Color.BLACK);
							
							serVisible(controlador, cas$i, vis$i);
							
							VistaPuntoDePoder vistaPuntoDePoder = new VistaPuntoDePoder();
							vistaPuntoDePoder.setPosicionable(cas$i);
							controlador.agregarDibujable(vistaPuntoDePoder);
							casilleroAux = new PuntoDePoder(posicion,tablero);
							
							
						}
						
						tablero.addCasillero(posicion, casilleroAux);
						
						r = r + 25;
					}
			   }
			  n = n + 25;
	    	}
		Punto nuevaDimension = new Punto(i, s);
		tablero.setDimension(nuevaDimension);
			
		}
		catch(Exception e){
			System.out.println ("Error al procesar el fichero de favoritos: " + e.getMessage());
		    e.printStackTrace();
		
		}
	}

	private static void serVisible(ControladorJuego controlador,
			PosicionCasillero cas$i, VistaCasillero vis$i) {
		vis$i.setPosicionable(cas$i);
		controlador.agregarDibujable(vis$i);
	}

}
