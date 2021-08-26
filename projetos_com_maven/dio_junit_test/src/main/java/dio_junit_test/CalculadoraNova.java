package dio_junit_test;

public class CalculadoraNova {
	
	/*public int somar(int valA, int valB) {
		int r = 0;
		r = valA + valB;
		return r;
	}*/

	public int somar(int ...valores) {
		int soma = 0;
		
		for (int valor : valores) {
			soma += valor;
		}
		
		return soma;
	}
	
}
