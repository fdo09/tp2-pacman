package modelo.vista.fijos;

import modelo.vista.control.Integrante;

public class PosicionCasillero implements Integrante {
private int x;
private int y;

		public PosicionCasillero(int x, int y){
			this.x = x;
			this.y = y;
			
		}

		public int getX() {
			// TODO Auto-generated method stub
			return this.x;
		}

		public int getY() {
			// TODO Auto-generated method stub
			return this.y;
		}

}
