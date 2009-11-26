package test;

// import fijos.*;
import junit.framework.TestCase;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class CargaTableroTest extends TestCase {
	
	
	public void testCargarTablero(){
		// Tablero nuevo = new Tablero(29,29,null);
		try {
			File file = new File("xml/tablero.xml");
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
						System.out.println("Punto X = " + s +" Punto Y = "+ i + " Casillero = " + ((Node)fstNm.item(0)).getNodeValue());
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
