package aplication;

import javax.swing.JOptionPane;

import modelo.Empresa;
import modelo.TipoProducto;

public class Aplication {
	static Empresa empresa = new Empresa("Mi empresa", 4, 1);

	public static void main(String[] args) {
		

		for (int i = 0; i < 6; i++) {
			String mensaje = empresa.crearProducto("Mueble", i+"", 20000, TipoProducto.MUEBLES);
			JOptionPane.showMessageDialog(null,mensaje);

		}


	}
}
