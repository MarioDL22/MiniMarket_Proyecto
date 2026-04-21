package logico;

import java.time.LocalDate;

public class Usuario {
	private String usuario; 
	private String correo; 
	private String password; 
	private TipoRol rol; 
	private LocalDate fechaCreacion; 
	
	public Usuario(String usuario, String correo, String password, TipoRol rol, LocalDate fechaCreacion) {
		super();
		this.usuario = usuario; 
		this.correo = correo;
		this.password = password;
		this.rol = rol;
		this.fechaCreacion = LocalDate.now();
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

	public TipoRol getRol() {
		return rol;
	}

	public void setRol(TipoRol rol) {
		this.rol = rol;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
