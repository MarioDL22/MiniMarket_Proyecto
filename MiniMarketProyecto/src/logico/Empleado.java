package logico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empleado extends Persona {
	private String correo; 
	private String password; 
	private String usuario; 
	private LocalDate fechaCreacion; 
	private boolean estado; 
	private TipoRol rol;
	private float sueldo; 
	private int cantHoras; 
	private ArrayList<Compra> misVentas; 
	
	public Empleado(String nombre, String cedula, String telefono, String direccion, String correo, String password,
			String usuario, TipoRol rol, int cantHoras) {
		super(nombre, cedula, telefono, direccion);
		this.correo = correo;
		this.password = password;
		this.usuario = usuario;
		this.fechaCreacion = LocalDate.now();
		this.estado = false;
		this.rol = rol;
		this.sueldo = 0.0f; 
		this.cantHoras = cantHoras; 
		this.misVentas = misVentas; 
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public TipoRol getRol() {
		return rol;
	}

	public void setRol(TipoRol rol) {
		this.rol = rol;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public int getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}

	public ArrayList<Compra> getMisVentas() {
		return misVentas;
	}

	public void setMisVentas(ArrayList<Compra> misVentas) {
		this.misVentas = misVentas;
	} 
	
	
}
