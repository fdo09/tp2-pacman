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

public class CargaTablero {
	
	public CargaTablero(){
		
	}
	
	public void Cargador(Tablero tab,File file){
		
		Casillero casilla;
		Punto nuevo;

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
						if ( tipoDeCasillero.equals("semilla")){
							casilla = new Semilla(nuevo, tab);
						}else if (tipoDeCasillero.equals("pared")){
							casilla = new Pared(nuevo, tab);
						}else {
							casilla = new PuntoDePoder(nuevo,tab);
						}
						tab.addCasillero(nuevo, casilla);
						System.out.println("Punto X = " + s +" Punto Y = "+ i + " Casillero = " + ((Node)fstNm.item(0)).getNodeValue());
						System.out.println(tab.equals(nuevo));
					}
			   }
	    	}		
		}
		catch(Exception e){
			System.out.println ("Error al procesar el fichero de favoritos: " + e.getMessage());
		    e.printStackTrace();
		
		}		
		
	
		
		
		
	}

}
