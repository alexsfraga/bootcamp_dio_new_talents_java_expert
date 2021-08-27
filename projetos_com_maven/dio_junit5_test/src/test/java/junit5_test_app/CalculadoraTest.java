package junit5_test_app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraTest {

	static Calculadora calculadora;
	
	@Test
	//@Disabled
	void testSomar() {
		double vA = 1;
		double vB = 2;
		double soma = calculadora.somar(vA , vB);
		
		assertEquals(3, soma);
	}
	@Test
	public void deveResultarZeroAoSomarDoisEMenosDois() {
		assertEquals(0.0 , calculadora.somar(2, -2));
	}
   
	@DisplayName("Valida multiplas somas com informações em CSV")
	@ParameterizedTest
	@CsvSource({"1.0 , 2.0" , "2.0 , 1.0" , "0.5 , 2.5"})
	public void verificaMultiplasSomasCSV(double parcela1, double parcela2) {
		assertEquals(3.0 , calculadora.somar(parcela1, parcela2));
	}
	
	@DisplayName("Valida multiplas somas com informações em Arquivo CSV")
	@ParameterizedTest
	@CsvFileSource( resources = "/data.csv", numLinesToSkip = 1 )
	public void verificaMultiplasSomasEmArquivoCSV(double parcela1, double parcela2, double resultado) {
		assertEquals(resultado , calculadora.somar(parcela1, parcela2));
	}
	
	@BeforeAll
	public static void newCalculadora() {
		calculadora = new Calculadora();
	}
	//outras anotações: @BeforeEach  @AfterEach  @AfterAll
	
}
