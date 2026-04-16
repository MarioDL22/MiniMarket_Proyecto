package logico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Compra {
	private Empleado elEmpleado;
	private Cliente elCliente; 
	private float montoTotal; 
	private ArrayList<Producto> losProductos; 
	private LocalDate fechaCompra; 
	private TipoPago pago; 
	private boolean usoDelivery; 
	private boolean credito;
	
	public Compra(Empleado elEmpleado, Cliente elCliente, float montoTotal, TipoPago pago, boolean usoDelivery, boolean credito) {
		super();
		this.elEmpleado = elEmpleado;
		this.elCliente = elCliente;
		this.montoTotal = montoTotal;
		this.losProductos = new ArrayList<Producto>();
		this.fechaCompra = LocalDate.now();
		this.pago = pago;
		this.usoDelivery = usoDelivery;
		this.credito = credito;
	}

	public Empleado getElEmpleado() {
		return elEmpleado;
	}

	public void setElEmpleado(Empleado elEmpleado) {
		this.elEmpleado = elEmpleado;
	}

	public Cliente getElCliente() {
		return elCliente;
	}

	public void setElCliente(Cliente elCliente) {
		this.elCliente = elCliente;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public ArrayList<Producto> getLosProductos() {
		return losProductos;
	}

	public void setLosProductos(ArrayList<Producto> losProductos) {
		this.losProductos = losProductos;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public TipoPago getPago() {
		return pago;
	}

	public void setPago(TipoPago pago) {
		this.pago = pago;
	}

	public boolean isUsoDelivery() {
		return usoDelivery;
	}

	public void setUsoDelivery(boolean usoDelivery) {
		this.usoDelivery = usoDelivery;
	}

	public boolean isCredito() {
		return credito;
	}

	public void setCredito(boolean credito) {
		this.credito = credito;
	} 
	
	
}
