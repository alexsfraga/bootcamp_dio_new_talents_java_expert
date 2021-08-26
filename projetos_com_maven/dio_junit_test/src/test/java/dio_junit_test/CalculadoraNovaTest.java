package dio_junit_test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculadoraNovaTest {

	@Test
	public void deveSomarDoisValores() {
		int valA = 1;
		int valB = 2;
		
		CalculadoraNova calcN = new CalculadoraNova();
		int soma = calcN.somar(valA , valB);
		
		assertEquals( 3 , soma);
	}

}
