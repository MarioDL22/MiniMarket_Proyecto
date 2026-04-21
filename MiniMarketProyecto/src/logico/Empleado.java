package logico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empleado extends Persona {
	private Usuario miUsuario; 
	private float sueldo; 
	private int cantHoras; 
	private ArrayList<Compra> misVentas; 
	private int cantVentas; 
	
	public Empleado(String identificador, String nombre, String cedula, String telefono, String direccion, Usuario miUsuario, int cantHoras) {
		super(identificador, nombre, cedula, telefono, direccion);
		this.miUsuario = miUsuario;
		this.sueldo = 0.0f;
		this.cantHoras = cantHoras;
		this.misVentas = new ArrayList<>();
		this.cantVentas = 0;
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

	public int getCantVentas() {
		return cantVentas;
	}

	public void setCantVentas(int cantVentas) {
		this.cantVentas = cantVentas;
	} 

	public Usuario getMiUsuario() {
		return miUsuario;
	}

	public void setMiUsuario(Usuario miUsuario) {
		this.miUsuario = miUsuario;
	}
	
	public float calcularSueldoNormal() {
		if(miUsuario.getRol() == TipoRol.Administrador) {
			return cantHoras * 500; 
		}else if (miUsuario.getRol() == TipoRol.Cajero) {
			return cantHoras * 250; 
		}
		
		return cantHoras * 100; 
	}
}
