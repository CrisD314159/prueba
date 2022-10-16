package test;

import junit.framework.TestCase;

public class TestCalculadora extends TestCase {
	private Calculadora calculadora;
	
	
	
	public void TestCalculadora() {
		calculadora = new Calculadora();
	}

	public void  testSumar() {
		TestCalculadora();		
		assertTrue(Calculadora.sumar(3, 3) == (3+4));
		
	}
	
	public  void  testMultiplicar() {
		TestCalculadora();
		assertTrue(Calculadora.multiplicar(3, 3) == (3*3));
		
	}
	public void  testDividir() {
		TestCalculadora();
		assertTrue(Calculadora.dividir(3, 3) == (3/3));
		
	}
	
	
	
}
