package logico;

import java.util.ArrayList;

public class Cliente {
	private ArrayList<Compra> misCompras; 
	private float deuda;
	
	public Cliente(ArrayList<Compra> misCompras) {
		super();
		this.misCompras = misCompras;
		this.deuda = 0.0f; 
	}

	public ArrayList<Compra> getMisCompras() {
		return misCompras;
	}

	public void setMisCompras(ArrayList<Compra> misCompras) {
		this.misCompras = misCompras;
	}

	public float getDeuda() {
		return deuda;
	}

	public void setDeuda(float deuda) {
		this.deuda = deuda;
	} 
	
	
}
