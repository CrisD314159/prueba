package modelo;

import java.util.Arrays;

public class Empresa {

	private String nombre;
	private Producto [] listaProductos;
	private Empleado [] listaEmpleados;

	public Empresa(String nombre, int tamanioProductos, int tamanioEmpleados){
		this.nombre = nombre;
		this.listaProductos = new Producto[tamanioProductos];
		this.listaEmpleados = new Empleado[tamanioEmpleados];
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Producto[] getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(Producto[] listaProductos) {
		this.listaProductos = listaProductos;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", listaProductos=" + Arrays.toString(listaProductos) + "]";
	}

	//CRUD Producto

	public String crearProducto(String nombre,String codigo,double precio, TipoProducto tipoProducto){
		String mensaje = "";

		Producto productoEncontrado = null;

		productoEncontrado = buscarProducto2(codigo);
		if(productoEncontrado == null){
			int posicionDisponible = obtenerPosicionDisponibleProducto();

			if(posicionDisponible == -1){
				mensaje = "No hay disponibilidad para m�s productos ";
			}else{
				productoEncontrado = new Producto(nombre, codigo, precio, tipoProducto);
				listaProductos [posicionDisponible]  = productoEncontrado;
				mensaje = "Producto creado exitosamente";
			}

		}else{
			mensaje = "El producto ya existe en la empresa";
		}
		return mensaje;
	}

	private int obtenerPosicionDisponibleProducto() {
		int pos = -1;
		for (int i = 0; i < listaProductos.length && pos == -1; i++) {
			if(listaProductos [i] == null){
				pos = i;
			}
		}
		return pos;
	}

	private Producto buscarProducto1(String codigo) {
		Producto productoEncontrado = null;

		for (int i = 0; i < listaProductos.length; i++) {
			Producto productoAux = listaProductos[i];
			if(productoAux != null && productoAux.getCodigo().equals(codigo)){
				productoEncontrado = productoAux;
				break;
			}
		}
		return productoEncontrado;
	}

	private Producto buscarProducto2(String codigo) {
		Producto productoEncontrado = null;

		for (int i = 0; i < listaProductos.length && productoEncontrado == null; i++) {
			Producto productoAux = listaProductos[i];
			if(productoAux != null && productoAux.getCodigo().equals(codigo)){
				productoEncontrado = productoAux;
			}
		}
		return productoEncontrado;
	}


	private Producto buscarProducto3(String codigo) {
		Producto productoEncontrado = null;

		for (int i = 0; i < listaProductos.length; i++) {
			Producto productoAux = listaProductos[i];
			if(productoAux != null && productoAux.getCodigo().equals(codigo)){
				return productoAux;
			}
		}
		return productoEncontrado;
	}


	public String eliminarProducto(String codigo){
		String mensaje = "";
		int posProducto = obtenerPosicionProducto(codigo);
		if(posProducto == -1){
			mensaje = "Producto no existe";
		}else{
			listaProductos [posProducto] = null;
			mensaje = "Producto eliminado";
		}

		return mensaje;

	}
	
	public String actualizarProducto(String codigo, double precio, String nombre){
		String mensaje = "";
		int posProducto = obtenerPosicionProducto(codigo);
		if(posProducto == -1){
			mensaje = "Producto no existe";
		}else{
			listaProductos [posProducto].setPrecio(precio);
			listaProductos [posProducto].setNombre(nombre);
			
			mensaje = "Producto actualizado";
		}

		return mensaje;

	}

	private int obtenerPosicionProducto(String codigo) {
		int pos = -1;

		for (int i = 0; i < listaProductos.length; i++) {
			if(listaProductos[i] != null && listaProductos[i].getCodigo().equals(codigo)){
				return i;
			}
		}
		return pos;
	}
	
	
	// CRUD EMPLEADO
	
	public String crearEmpleado (String nombre, String correo, String cedula, String direccion, double salario) {
		 String mensaje = "";
		 Empleado empleadoEncontrado = null;

		    empleadoEncontrado  = buscarEmpleado(cedula);
			if(empleadoEncontrado == null){
				int posicionDisponible = obtenerPosicionDisponibleEmpleado();

				if(posicionDisponible == -1){
					mensaje = "No hay disponibilidad para m�s empleados ";
				}else{
					empleadoEncontrado= new Empleado(nombre, correo, cedula, direccion, salario);
					listaEmpleados [posicionDisponible]  = empleadoEncontrado;
					mensaje = "Empleado creado exitosamente";
				}

			}else{
				mensaje = "Imposible crear el empleado";
			}
		
		return mensaje;
	}

	private int obtenerPosicionDisponibleEmpleado() {
		int pos = -1;
		for (int i = 0; i < listaEmpleados.length && pos == -1; i++) {
			if(listaEmpleados [i] == null){
				pos = i;
			}
		}
		return pos;
	}

	private Empleado buscarEmpleado(String cedula) {
		Empleado empleadoEncontrado = null;
		for (int i = 0; i < listaEmpleados.length && empleadoEncontrado== null; i++) {
			Empleado empleadoAux = listaEmpleados[i];
			if(empleadoAux!= null && empleadoAux.getCedula().equals(cedula)){
				empleadoEncontrado = empleadoAux;
			}
		}
		return empleadoEncontrado;
	}
	
	
	
	public String eliminarEmpleado(String cedula){
		String mensaje = "";
		int posEmpleado = obtenerPosicionEmpleado(cedula);
		if( posEmpleado == -1){
			mensaje = "Empleado no existe";
		}else{
			listaEmpleados [ posEmpleado] = null;
			mensaje = "Empleado eliminado";
		}

		return mensaje;

	}

	private int obtenerPosicionEmpleado(String cedula) {
		int pos = -1;

		for (int i = 0; i < listaEmpleados.length; i++) {
			if(listaEmpleados[i] != null && listaEmpleados[i].getCedula().equals(cedula)){
				return i;
			}
		}
		return pos;
	}
	public String actualizarEmpleado(String cedula, String nombre, String direccion, String correo){
		String mensaje = "";
		int posEmpleado = obtenerPosicionEmpleado(cedula);
		if( posEmpleado  == -1){
			mensaje = "Empleado no existe";
		}else{
			listaEmpleados [ posEmpleado ].setDireccion(direccion);
			listaEmpleados [ posEmpleado ].setCorreo(correo);;
			
			listaEmpleados [ posEmpleado ].setNombre(nombre);
			
			mensaje = "Empleado actualizado";
		}

		return mensaje;

	}

	// tiene que: actuliazar producto,hacer el CRUD empleado y buscar JUNIT
}
