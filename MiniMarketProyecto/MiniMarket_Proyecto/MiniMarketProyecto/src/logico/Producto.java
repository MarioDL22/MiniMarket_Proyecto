package logico;

import java.time.LocalDate;

public class Producto {

	private String marca; 
	private int cantidad; 
	private float precio; 
	private TipoProducto tipo;
	private LocalDate fechaExpiracion; 
	private boolean enVenta; 
	
	public Producto(String marca, int cantidad, float precio, TipoProducto tipo, LocalDate fechaExpiracion,
			boolean enVenta) {
		super();
		this.marca = marca;
		this.cantidad = cantidad;
		this.precio = precio;
		this.tipo = tipo;
		this.fechaExpiracion = fechaExpiracion;
		this.enVenta = enVenta;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public TipoProducto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}

	public LocalDate getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(LocalDate fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public boolean isEnVenta() {
		return enVenta;
	}

	public void setEnVenta(boolean enVenta) {
		this.enVenta = enVenta;
	}
}
