package desafio.locker.poker.testes;

import desafio.locker.poker.modelos.Carta;
import desafio.locker.poker.modelos.NaipeEnum;
import desafio.locker.poker.modelos.ValorEnum;

public class CompararCartasTeste {

	public static void main(String[] args) {
		
		//Mostra a diferenca de valores entre cartas

		Carta carta = new Carta(ValorEnum.QUATRO, NaipeEnum.COPAS);
		Carta carta2 = new Carta(ValorEnum.DEZ, NaipeEnum.COPAS);
		Carta carta3 = new Carta(ValorEnum.OITO, NaipeEnum.COPAS);
		Carta carta4 = new Carta(ValorEnum.AS, NaipeEnum.COPAS);
		
		int resultado = carta.compareTo(carta);
		int resultado2 = carta.compareTo(carta2);
		int resultado3 = carta.compareTo(carta3);
		int resultado4 = carta.compareTo(carta4);
		
		System.out.println(resultado);
		System.out.println(resultado2);
		System.out.println(resultado3);
		System.out.println(resultado4);
		
		System.out.println();
		
		int _resultado = carta2.compareTo(carta);
		int _resultado2 = carta3.compareTo(carta2);
		int _resultado3 = carta4.compareTo(carta);
		int _resultado4 = carta4.compareTo(carta2);
		
		System.out.println(_resultado);
		System.out.println(_resultado2);
		System.out.println(_resultado3);
		System.out.println(_resultado4);
		
	}

}
