package logico;

import java.util.ArrayList;

public class MiniMarket {
	private static final long serialVersionUID = 1L;
	public static MiniMarket miniMarket = null; 
	public static int genIdEmpleado = 1; 
	public static int genIdCliente = 1; 
	public static int genIdProducto = 1; 
	public static int genIdCompra = 1; 
	private ArrayList<Persona> misPersonas; 
	private ArrayList<Empleado> misEmpleados; 
	private ArrayList<Cliente> misClientes;
	private ArrayList<Producto> misProductos; 
	private ArrayList<Compra> misCompras;
	
	public MiniMarket() {
		super();
		this.misPersonas = new ArrayList<>(); 
		this.misEmpleados = new ArrayList<>();
		this.misClientes = new ArrayList<>();
		this.misProductos = new ArrayList<>();
		this.misCompras = new ArrayList<>();
	} 
	
	public static MiniMarket getInstance() {
		if(miniMarket == null) {
			miniMarket = new MiniMarket();
		}
		return miniMarket;
	}

	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}

	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}

	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}

	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public ArrayList<Producto> getMisProductos() {
		return misProductos;
	}

	public void setMisProductos(ArrayList<Producto> misProductos) {
		this.misProductos = misProductos;
	}

	public ArrayList<Compra> getMisCompras() {
		return misCompras;
	}

	public void setMisCompras(ArrayList<Compra> misCompras) {
		this.misCompras = misCompras;
	}
	
	
}
