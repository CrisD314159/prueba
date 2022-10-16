package modelo;

import java.util.Objects;

public class Empleado {
	
	private String nombre;
	private String correo;
	private String cedula;
	private String direccion;
	private double salario;
	
	public Empleado(String nombre, String correo, String cedula, String direccion, double salario) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.cedula = cedula;
		this.direccion = direccion;
		this.salario = salario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", correo=" + correo + ", cedula=" + cedula + ", direccion=" + direccion
				+ ", salario=" + salario + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cedula, correo, direccion, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(cedula, other.cedula) && Objects.equals(correo, other.correo)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(nombre, other.nombre);
	}
	
	
	

}
