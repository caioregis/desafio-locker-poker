package desafio.locker.poker.testes;

import desafio.locker.poker.jogo.Jogo;
import desafio.locker.poker.modelos.Jogador;

public class JogoDarCartasTeste {

	public static void main(String[] args) {
	
		Jogo jogo = new Jogo();
		jogo.darCartas();
		
		for(Jogador jogador : jogo.getJogadores()) {
			System.out.println(jogador.getMao());
		}
	}
}
