package logico;

import java.time.LocalDate;
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
	
	public Producto buscarProductoById(String identificador) {
		Producto auxProducto = null; 
		int ind = 0; 
		boolean encontrado = false; 
		
		while(!encontrado && ind < misProductos.size()) {
			if(misProductos.get(ind).getIdentificador().equalsIgnoreCase(identificador)) {
				auxProducto = misProductos.get(ind); 
				encontrado = true; 
			}
			ind++; 
		}
		
		return auxProducto; 
	}
	
	public int buscarProducto(String identificador) {
		int aux = -1; 
		boolean encontrado = false; 
		int ind = 0; 
		
		while (!encontrado && ind < misProductos.size()) {
			if(misProductos.get(ind).getIdentificador().equalsIgnoreCase(identificador)) {
				encontrado = true; 
				aux = ind; 
			}
			ind++; 
		}
		
		return aux; 
	}
	
	public void ingresarProducto(Producto myProducto) {
		misProductos.add(myProducto); 
		genIdProducto++; 
	}
	
	public void actualizarProducto(Producto myProducto) {
		int index = buscarProducto(myProducto.getIdentificador()); 
		if(index != -1) {
			misProductos.set(index, myProducto); 
		}
	}
	
	public Empleado buscarEmpleadoById(String identificador) {
		Empleado axuEmpleado = null; 
		int ind = 0; 
		boolean encontrado = false; 
		
		while(!encontrado && ind < misEmpleados.size()) {
			if(misEmpleados.get(ind).getIdentificador().equalsIgnoreCase(identificador)) {
				axuEmpleado = misEmpleados.get(ind); 
				encontrado = true; 
			}
			ind++; 
		}
		
		return axuEmpleado; 
	}
	
	public int buscarEmpleado(String identificador) {
		int aux = -1; 
		boolean encontrado = false; 
		int ind = 0; 
		
		while (!encontrado && ind < misEmpleados.size()) {
			if(misEmpleados.get(ind).getIdentificador().equalsIgnoreCase(identificador)) {
				encontrado = true; 
				aux = ind; 
			}
			ind++; 
		}
		
		return aux; 
	}
	
	public void ingresarEmpleado(Empleado axuEmpleado) {
		misEmpleados.add(axuEmpleado); 
		genIdEmpleado++; 
	}
	
	public void actualizarEmpleado(Empleado axuEmpleado) {
		int index = buscarEmpleado(axuEmpleado.getIdentificador()); 
		if(index != -1) {
			misEmpleados.set(index, axuEmpleado); 
		}
	}
	
	public Cliente buscarClienteById(String identificador) {
		Cliente auxCliente = null; 
		int ind = 0; 
		boolean encontrado = false; 
		
		while(!encontrado && ind < misClientes.size()) {
			if(misClientes.get(ind).getIdentificador().equalsIgnoreCase(identificador)) {
				auxCliente = misClientes.get(ind); 
				encontrado = true; 
			}
			ind++; 
		}
		
		return auxCliente; 
	}
	
	public int buscarCliente(String identificador) {
		int aux = -1; 
		boolean encontrado = false; 
		int ind = 0; 
		
		while (!encontrado && ind < misClientes.size()) {
			if(misClientes.get(ind).getIdentificador().equalsIgnoreCase(identificador)) {
				encontrado = true; 
				aux = ind; 
			}
			ind++; 
		}
		
		return aux; 
	}
	
	public void ingresarCliente(Cliente auxCliente) {
		misClientes.add(auxCliente); 
		genIdCliente++; 
	}
	
	public void actualizarCliente(Cliente auxCliente) {
		int index = buscarCliente(auxCliente.getIdentificador()); 
		if(index != -1) {
			misClientes.set(index, auxCliente); 
		}
	}
	
	public Compra buscarCompraById(String identificador) {
		Compra auxCompra = null; 
		int ind = 0; 
		boolean encontrado = false; 
		
		while(!encontrado && ind < misCompras.size()) {
			if(misCompras.get(ind).getIdentificador().equalsIgnoreCase(identificador)) {
				auxCompra = misCompras.get(ind); 
				encontrado = true; 
			}
			ind++; 
		}
		
		return auxCompra; 
	}
	
	public void ingresarCompra(Compra auxCompra) {
		misCompras.add(auxCompra); 
		genIdCompra++; 
	}
	
	public float realizarCompra(String idEmpleado, String idCliente, TipoPago tipoPago) {
		float total = 0;
		float subTotal = 0; 
		Cliente auxCliente = buscarClienteById(idCliente); 
		Empleado auxEmpleado = buscarEmpleadoById(idEmpleado); 
		
		if(auxCliente != null && auxEmpleado != null) {
			LocalDate hoyDate = LocalDate.now(); 
			String idCompra = "PO-" + genIdCompra; 
			Compra auxCompra = new Compra(idCompra, auxEmpleado, auxCliente, tipoPago, hoyDate);
			
			subTotal = auxCompra.sumaPreciosProductos(); 
			total = subTotal + (subTotal * 0.18f); 
			auxCompra.setMontoTotal(total);
			
			if(auxEmpleado.getRol() == TipoRol.Delivery) {
				auxCompra.setUsoDelivery(true);
			}else {
				auxCompra.setUsoDelivery(false);
			}
			
			if (tipoPago == TipoPago.Credito) {
				auxCompra.setCredito(true);
				auxCliente.setDeuda(auxCliente.getDeuda() + total);
			}
			
			ingresarCompra(auxCompra);
			auxCliente.getMisCompras().add(auxCompra); 
			auxEmpleado.getMisVentas().add(auxCompra); 
			auxCompra.disminuirStockProducto();
		}
		return total; 
	}
	
	public float calcularNomina(Empleado elEmpleado) {
		float total = 0; 
		int cantVentas = 0; 
		for (Compra auxCompra : misCompras) {
			if(auxCompra.getElEmpleado().getIdentificador().equalsIgnoreCase(elEmpleado.getIdentificador())) {
				cantVentas++; 
			}
		}
		
		total = (cantVentas * 100) + elEmpleado.calcularSueldoNormal(); 
		elEmpleado.setSueldo(total);
		return total; 
	}
}
