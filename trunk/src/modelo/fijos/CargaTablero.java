package modelo.fijos;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class CargaTablero {
	
	public CargaTablero(){
		
	}
	
	public Tablero cargar(String path){
		
		Casillero casilleroAux = null;
		Punto posicion;
		Tablero tablero;
		File file = new File(path);
		int s = 0;
		int i = 0;
		try {
			tablero = new Tablero(32,32);
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
					for (  i = 0; i < fstNmElemLst.getLength(); i++){
						Element fir = (Element) fstNmElemLst.item(i);
						NodeList fstNm = fir.getChildNodes();
						posicion = new Punto(i, s);
						String tipoDeCasillero = ((Node)fstNm.item(0)).getNodeValue();
						if ( tipoDeCasillero.equals("semilla")){
							casilleroAux = new Semilla(posicion, tablero);
						}else if (tipoDeCasillero.equals("pared")){
							casilleroAux = new Pared(posicion, tablero);
						}else if (tipoDeCasillero.equals("casa")){
							casilleroAux = new Casa(posicion, tablero);
							tablero.agregarCasa(posicion);
						}else if (tipoDeCasillero.equals("PuntoDePoder")){
							casilleroAux = new PuntoDePoder(posicion,tablero);
						}
						tablero.addCasillero(posicion, casilleroAux);
						// System.out.println("Punto X = " + s +" Punto Y = "+ i + " Casillero = " + ((Node)fstNm.item(0)).getNodeValue());
						// System.out.println(tab.esTransitable(nuevo));
					}
			    }
	    	}
		    Punto nuevaDimension = new Punto(s, i);
		    tablero.setDimension(nuevaDimension);
			return tablero;
		}
		catch(Exception e){
			System.out.println ("Error al procesar el fichero de favoritos: " + e.getMessage());
		    e.printStackTrace();
		
		}		
		
	
		
		return null;
		
	}

}
