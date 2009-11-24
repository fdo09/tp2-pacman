package fijos;



import java.io.InputStream;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.util.Vector;

public class ManejadorTablero extends DefaultHandler {
	
	private String valor = null;
	private Vector instancia;
	private Tablero tablero;
	
	public ManejadorTablero( Vector v){
		this.instancia = v;
	}
	
	public void startElement( String name, String localname, String qname, Attributes attr ) throws SAXException {
		
		
		
	}
	
	

}
