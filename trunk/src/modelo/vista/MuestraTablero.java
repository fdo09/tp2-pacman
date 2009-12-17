package modelo.vista;

import java.awt.Color;
import java.util.ArrayList;

import modelo.fijos.Casa;
import modelo.fijos.Casillero;
import modelo.fijos.Juego;
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
import modelo.vista.fijos.VistaCasillero;
import modelo.vista.fijos.VistaPuntoDePoder;
import modelo.vista.fijos.VistaSemilla;
import modelo.vista.moviles.VistaFantasmaAmarillo;
import modelo.vista.moviles.VistaFantasmaAzul;
import modelo.vista.moviles.VistaFantasmaInmune;
import modelo.vista.moviles.VistaFantasmaNaranja;
import modelo.vista.moviles.VistaFantasmaRojo;
import modelo.vista.moviles.VistaPacman;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class MuestraTablero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ControladorJuego controlador = new ControladorJuego();
		
		Juego juego = new Juego();
		
		Tablero tablero = juego.getTablero();
		Pacman pacman = tablero.getPacman();
		
		controlador.agregarKeyPressObservador(new EscuchadorDeKeyPress(pacman));
		
		VentanaPrincipal ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana.getSuperficieDeDibujo());
		ventana.setVisible(true);
		
			
	
		generarVistaDeCasilleros(controlador, tablero);
		
		VistaPacman vistaPacman = getVistaPacman(tablero, pacman);
		
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
				VistaFantasmaRojo vistaRojo = new VistaFantasmaRojo(f);
				vistaRojo.setPosicionable(f);
				controlador.agregarDibujable(vistaRojo);
			}
			else if(f.getClass().equals(FantasmaAmarillo.class)){
				VistaFantasmaAmarillo vistaAmarillo = new VistaFantasmaAmarillo(f);
			    vistaAmarillo.setPosicionable(f);
			    controlador.agregarDibujable(vistaAmarillo);
			}
			else if(f.getClass().equals(FantasmaInmune.class)){
				VistaFantasmaInmune vistaInmune = new VistaFantasmaInmune(f);
			    vistaInmune.setPosicionable(f);
			    controlador.agregarDibujable(vistaInmune);
			}
			else if(f.getClass().equals(FantasmaNaranja.class)){
				VistaFantasmaNaranja vistaNaranja = new VistaFantasmaNaranja(f);
				vistaNaranja.setPosicionable(f);
				controlador.agregarDibujable(vistaNaranja);
			}
			else if(f.getClass().equals(FantasmaAzul.class)){
				VistaFantasmaAzul vistaAzul = new VistaFantasmaAzul(f);
				vistaAzul.setPosicionable(f);
				controlador.agregarDibujable(vistaAzul);
			}
			controlador.agregarObjetoVivo(f);
		
		}
	}

	private static VistaPacman getVistaPacman(Tablero tablero, Pacman pacman) {
		VistaPacman vistaPacman = new VistaPacman(pacman);
		vistaPacman.setPosicionable(pacman);;
		return vistaPacman;
	}

	private static void generarVistaDeCasilleros(ControladorJuego controlador, Tablero tablero) {
		Punto dimension = tablero.getDimension();
		for ( int x = 0; x < dimension.getPuntoX(); x++ ){
			
			for (int y = 0; y < dimension.getPuntoY(); y++ ){
				
				Punto posicionCasillero = new Punto (x,y);
				Punto posicionPantalla = new Punto (x*25, y*25);
				Casillero casilleroActual = tablero.getCasillero(posicionCasillero);
				VistaCasillero vistaCasillero = new VistaCasillero();
				
				if (casilleroActual.getClass().equals(Semilla.class)){
					vistaCasillero.setColor(Color.BLACK);
					serVisible(controlador, posicionPantalla, vistaCasillero);
					
					VistaSemilla vistaSemilla = new VistaSemilla(casilleroActual);
					vistaSemilla.setPosicionable(posicionPantalla);
					controlador.agregarDibujable(vistaSemilla);
				}
				
				else if (casilleroActual.getClass().equals(Pared.class)){
					vistaCasillero.setColor(Color.BLUE);
					serVisible(controlador, posicionPantalla, vistaCasillero);
				}
				
				else if (casilleroActual.getClass().equals(Casa.class)){
					vistaCasillero.setColor(Color.GREEN);
					serVisible(controlador, posicionPantalla, vistaCasillero);
				}
				
				else if (casilleroActual.getClass().equals(PuntoDePoder.class)){
					vistaCasillero.setColor(Color.BLACK);
					serVisible(controlador, posicionPantalla, vistaCasillero);
					
					VistaPuntoDePoder vistaPtoPoder = new VistaPuntoDePoder(casilleroActual);
					vistaPtoPoder.setPosicionable(posicionPantalla);
					controlador.agregarDibujable(vistaPtoPoder);
				}
			}
		}
		
	}
		/*
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
	*/

	private static void serVisible(ControladorJuego controlador,
			Punto cas$i, VistaCasillero vis$i) {
		vis$i.setPosicionable(cas$i);
		controlador.agregarDibujable(vis$i);
	}

}
