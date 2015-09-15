package desafio.locker.poker.jogo;

import java.util.ArrayList;
import java.util.List;

import desafio.locker.poker.modelos.Baralho;
import desafio.locker.poker.modelos.Carta;
import desafio.locker.poker.modelos.Jogador;

public class Jogo {
	
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	private Baralho baralho;
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}


	public Jogo() {
		
		for(int i=1; i<=2; i++) {
			jogadores.add(new Jogador("Jogador "+i));
		}
		
		baralho = new Baralho();
		baralho.embaralhar();
		darCartas();
	}
	
	
	/*Adiciona 5 cartas para a mão do jogador 
	*e as retiram do baralho para não ser usadas duas vezes
	*/
	public void darCartas() {
		
		for(Jogador jogador : jogadores) {
			
			List<Carta> maoJogador = new ArrayList<Carta>();
			maoJogador.add(baralho.getCartas().remove(0));
			maoJogador.add(baralho.getCartas().remove(0));
			maoJogador.add(baralho.getCartas().remove(0));
			maoJogador.add(baralho.getCartas().remove(0));
			maoJogador.add(baralho.getCartas().remove(0));
						
			jogador.setMao(maoJogador);
		}
	}
	
}
