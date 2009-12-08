package modelo.vista;
import java.awt.Color;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import ar.uba.fi.algo3.titiritero.ControladorJuego;


public class MuestraMiniTablero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		PosicionTablero unTablero = new PosicionTablero(200,200);
		ControladorJuego controlador = new ControladorJuego();
	
		VentanaPrincipal ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana.getSuperficieDeDibujo());
		ventana.setVisible(true);
		VistaTablero vistaTablero = new VistaTablero();
		vistaTablero.setPosicionable(unTablero);

		controlador.agregarDibujable(vistaTablero);
		
		
		File file = new File("xml/miniTablero.xml");
		try {
			int n = 25;
			int r = 0;
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
					r = 1;
					for ( int i = 0; i < fstNmElemLst.getLength(); i++){
						
						Element fir = (Element) fstNmElemLst.item(i);
						NodeList fstNm = fir.getChildNodes();
						String tipoDeCasillero = ((Node)fstNm.item(0)).getNodeValue();
						PosicionCasillero cas$i = new PosicionCasillero(r,n);
						VistaCasillero vis$i = new VistaCasillero();
						if ( tipoDeCasillero.equals("semilla")){
							
							vis$i.setColor(Color.BLUE);
							
							
						}else if (tipoDeCasillero.equals("pared")){
							
							vis$i.setColor(Color.GRAY);
							
						
							
						}else if (tipoDeCasillero.equals("casa")){
							
							vis$i.setColor(Color.WHITE);
							
							
														
						}else if (tipoDeCasillero.equals("PuntoDePoder")){
							
							vis$i.setColor(Color.RED);
							
							
						}
						vis$i.setPosicionable(cas$i);
						controlador.agregarDibujable(vis$i);
						// System.out.println("Punto X = " + s +" Punto Y = "+ i + " Casillero = " + ((Node)fstNm.item(0)).getNodeValue());
						// System.out.println(tab.esTransitable(nuevo));
						if ( r == 1){ r = 25;}
						else {	r = r + 25; }
					}
			   }
			  n = n + 25;
	    	}
			
		}
		catch(Exception e){
			System.out.println ("Error al procesar el fichero de favoritos: " + e.getMessage());
		    e.printStackTrace();
		
		}		
		
		controlador.agregarMouseClickObservador(vistaTablero);
		
		controlador.setIntervaloSimulacion(20);
		controlador.comenzarJuego();
		
		
		
		
	}

}
