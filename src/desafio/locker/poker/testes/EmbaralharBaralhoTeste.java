package desafio.locker.poker.testes;

import desafio.locker.poker.modelos.Baralho;

public class EmbaralharBaralhoTeste {

	public static void main(String[] args) {
		
		Baralho baralho = new Baralho();
		
		//Mostrar baralho de acordo como foi criado
		System.out.println(baralho.getCartas());
		
		baralho.embaralhar();
		
		//Pular linha
		System.out.println();
		
		//Mostar baralho embaralhado
		System.out.println(baralho.getCartas());

	}

}
