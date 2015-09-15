package desafio.locker.poker.testes;

import desafio.locker.poker.modelos.Carta;
import desafio.locker.poker.modelos.Naipe;
import desafio.locker.poker.modelos.Valor;

public class TesteCompararCartas {

	public static void main(String[] args) {
		
		//Mostra a diferenca de valores entre cartas

		Carta carta = new Carta(Valor.QUATRO, Naipe.COPAS);
		Carta carta2 = new Carta(Valor.DEZ, Naipe.COPAS);
		Carta carta3 = new Carta(Valor.OITO, Naipe.COPAS);
		Carta carta4 = new Carta(Valor.AS, Naipe.COPAS);
		
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
