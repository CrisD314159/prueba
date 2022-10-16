package test;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import junit.framework.TestCase;
import modelo.Empresa;

public class Test extends TestCase{
	 static Empresa empresa = new Empresa("Boy toys", 2, 1);
	public static void main(String[] args) {
		
		empresa.crearEmpleado("juan", "juanEmail", "1234567", "cl 13 n2", 1000000);
		int numArraylist = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de empresas que quieres crear"));
		
		
	
	//Aqui se crea el arraylist
		
		ArrayList<String> empresas = crearArraylist(numArraylist);
		
		JOptionPane.showMessageDialog(null, empresas);
		
		
		//aqui se actualiza un elemento del arraylist
		
		int elementoActualizar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la empresa que quieras sustituir"));
		String empresaActualizar = JOptionPane.showInputDialog("Ingresa la empresa");
		String empresaAtualizado= actualizarElementoArraylist(elementoActualizar,empresas, empresaActualizar); 
		
		JOptionPane.showMessageDialog(null, empresaAtualizado);
		JOptionPane.showMessageDialog(null, empresas);
		
		
		//aqui se elimina un elemeto del arraylist
		
		int elemento = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la empresa que quieras eliminar"));
		
		String empresaELiminado = eliminarElementoArraylist(elemento,empresas); 
		
		JOptionPane.showMessageDialog(null, empresaELiminado);
		JOptionPane.showMessageDialog(null, empresas);
			
			
		}
	
	public static ArrayList<String> crearArraylist(int numArraylist) {
		
		String mensaje ="";
		
		ArrayList<String> empresas = new ArrayList<String>(numArraylist);
			for(int i = 0; i<numArraylist; i++) {
				mensaje = JOptionPane.showInputDialog("Ingrese la empresa numero " + (i+1));
				empresas.add(mensaje);	
			}
		
		
		return empresas;
	}
	
	public static String eliminarElementoArraylist(int elemento, ArrayList<String> empresas) {
		
		String mensaje ="Imposible eliminar el elemento " + elemento;
		
		
		if (empresas != null) {
			
			empresas.remove(elemento);
			mensaje = "Elemento " + elemento + " eliminado exitosamente";
		}
		
		
		
		
		return mensaje;
	}
	
	public static String actualizarElementoArraylist(int elemento, ArrayList<String> empresas, String empresaSustituir) {
		
		String mensaje ="Imposible actualizar la empresa " + elemento;
		
		
		if (empresas != null) {
			
			empresas.set(elemento, empresaSustituir);
			mensaje = "Empresa numero " + elemento + " actualizada exitosamente";
		}
		
		
		
		
		return mensaje;
	}
	
	
	
	
	
	
	
	
	
	
}
