public class CPF {

	public static void verifica(String cpfDigitado) {
		
		int produto = 0;
		int soma = 0;
		int multiplicador = 10;
		int digitoVerificador1;
		int digitoVerificador2;
		int digito;
		
		// formata o cpf sem pontos e tra�os.
		String cpf = cpfDigitado.replaceAll("[^0-9]", "");

		// Verifica, ap�s formata��o, se cont�m 11 d�gitos.
		if (cpf.length() > 11) {
			System.out.println("CPF Inv�lido! Digite o cpf com 11 d�gitos");
		}else {
			
			//
			//
			// C�lculo do primeiro d�gito verificador.
			for (int i = 0; i < 9; i++) {
				digito = Character.getNumericValue(cpf.charAt(i));
				produto = digito * multiplicador;
				soma += produto;
				multiplicador--;
			}
			
			int resto = 11 - (soma % 11);
			if (resto < 10) {
				digitoVerificador1 = resto;
			} else {
				digitoVerificador1 = 0;
			}
			
			//
			//
			// Calculo do segundo d�gito verificador.
			soma = 0;
			multiplicador = 11;
			for (int i = 0; i < 10; i++) {
				digito = Character.getNumericValue(cpf.charAt(i));
				produto = digito * multiplicador;
				soma += produto;
				multiplicador--;
			}
	
			resto = 11 - (soma % 11);
			if (resto < 10) {
				digitoVerificador2 = resto;
			} else {
				digitoVerificador2 = 0;
			}
			
			//Verifica��o se os d�gitos verificadores passados correspondem aos d�gitos corretos.
			if ( digitoVerificador1 == Character.getNumericValue(cpf.charAt(9)) && digitoVerificador2 == Character.getNumericValue(cpf.charAt(10))){
				System.out.println("CPF v�lido");
			}else{
				System.out.println("CPF Inv�lido. D�gitos verificadores n�o correspondem a um cpf v�lido.");
			}
		}
	}

}
