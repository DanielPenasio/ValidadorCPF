public class CPF {

	public static void verifica(String cpfDigitado) {
		
		int produto = 0;
		int soma = 0;
		int multiplicador = 10;
		int digitoVerificador1;
		int digitoVerificador2;
		int digito;
		
		// formata o cpf sem pontos e traços.
		String cpf = cpfDigitado.replaceAll("[^0-9]", "");

		// Verifica, após formatação, se contém 11 dígitos.
		if (cpf.length() > 11) {
			System.out.println("CPF Inválido! Digite o cpf com 11 dígitos");
		}else {
			
			//
			//
			// Cálculo do primeiro dígito verificador.
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
			// Calculo do segundo dígito verificador.
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
			
			//Verificação se os dígitos verificadores passados correspondem aos dígitos corretos.
			if ( digitoVerificador1 == Character.getNumericValue(cpf.charAt(9)) && digitoVerificador2 == Character.getNumericValue(cpf.charAt(10))){
				System.out.println("CPF válido");
			}else{
				System.out.println("CPF Inválido. Dígitos verificadores não correspondem a um cpf válido.");
			}
		}
	}

}
