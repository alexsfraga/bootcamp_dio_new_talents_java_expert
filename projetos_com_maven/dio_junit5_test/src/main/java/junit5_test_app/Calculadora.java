package junit5_test_app;

public class Calculadora {
	
	public double somar(double ...valores) {
		double soma = 0;
		
		for (double valor : valores) {
			soma += valor;
		}
		
		return soma;
	}
	
}
