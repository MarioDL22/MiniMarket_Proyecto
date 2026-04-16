package logico;

import java.time.LocalDate;

public class Empleado extends Persona {
	private String correo; 
	private String password; 
	private String usuario; 
	private LocalDate fechaCreacion; 
	private boolean estado; 
	private TipoRol rol;
	
	public Empleado(String nombre, String cedula, String telefono, String direccion, String correo, String password,
			String usuario, TipoRol rol) {
		super(nombre, cedula, telefono, direccion);
		this.correo = correo;
		this.password = password;
		this.usuario = usuario;
		this.fechaCreacion = LocalDate.now();
		this.estado = false;
		this.rol = rol;
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
	
	
}
