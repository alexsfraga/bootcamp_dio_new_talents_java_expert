package dio_junit_test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class CalculadoraTest {

	@Test
	public void testSomar() {
		Calculadora calc = new Calculadora();
		
		int soma = calc.somar("1+1+3");
		assertEquals(5, soma);
	}
	
	@Test
	public void testSomarComMock() {
		Calculadora calc = mock(Calculadora.class);
		
		when(calc.somar("1+2")).thenReturn(4);
		
		int resultado = calc.somar("1+2");
		
		assertEquals(4, resultado);
	}

}
