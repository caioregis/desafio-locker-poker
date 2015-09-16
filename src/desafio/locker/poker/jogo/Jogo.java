package desafio.locker.poker.jogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import desafio.locker.poker.modelos.Baralho;
import desafio.locker.poker.modelos.Carta;
import desafio.locker.poker.modelos.Jogador;
import desafio.locker.poker.modelos.PokerRegraEnum;
import desafio.locker.poker.modelos.ValorEnum;


public class Jogo {
	
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	private Baralho baralho;
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	
	public void setJogadores(Jogador jogador) {
		jogadores.add(jogador);
	}

	
	/*
	 * Construtor - Adiciona os jogadores
	 * Inicia e embaralha o baralho
	 * Dá as cartas para os jogadores
	 * E mostra o Vencedor
	 */
	public Jogo() {
		
		for(int i=1; i<=2; i++) {
			jogadores.add(new Jogador("Jogador "+i));
		}
		
		baralho = new Baralho();
		baralho.embaralhar();
		darCartas();
		
		System.out.println(determinarVencedor());
		
	}
	
	/*
	 * Checa e pontua a mão de cada Jogador
	 * Compara as pontuações
	 * Determina o Vencedor do Jogo
	 */
	public String determinarVencedor() {
		
		Jogador jogadorVencedor = null;
		int pontuacaoVencedora = 0;
		List<Carta> melhoresCartas = null;
		boolean empate = false;
		
		for(Jogador jogador : jogadores) {
			jogador.setPontuacao(checarMao(jogador.getMao()));
			
			//Se a pontuação do atual é maior que a antiga, atualiza o vencedor
			if(jogador.getPontuacao().getValor() > pontuacaoVencedora) {
				jogadorVencedor = jogador;
				pontuacaoVencedora = jogador.getPontuacao().getValor();
				melhoresCartas = jogador.getMao();
				empate = false;
			} 
			//Se a pontuação do atual é igual da antiga, vence a mão formada pelas cartas de maior valor. 
			else if (jogador.getPontuacao().getValor() == pontuacaoVencedora &&
					jogadorVencedor != jogador) {
				
				Boolean novoVencedor = null;
				
				Collections.sort(jogadorVencedor.getMao());
				Collections.sort(jogador.getMao());
				
				for(int i=0; i<=4; i++) {
					if(jogador.getMao().get(i).getValor().getValorNumero() > 
						melhoresCartas.get(i).getValor().getValorNumero()) {
						
						novoVencedor = true;
						empate = false;
					
					} else if (jogador.getMao().get(i).getValor().getValorNumero() == 
						melhoresCartas.get(i).getValor().getValorNumero()) {
					
					} else {
						novoVencedor = false;
			            break;
					}
				}
				
				if (novoVencedor == null) {
		          empate = true;
		        }
		        else if (novoVencedor) {
		        	empate = false;
		        	jogadorVencedor = jogador;
					melhoresCartas = jogador.getMao();
					pontuacaoVencedora = jogador.getPontuacao().getValor();
		        }
			}
			
			System.out.println(jogador.getNome());
			System.out.println(jogador.getMao());
		    System.out.print(jogador.getPontuacao());
		    System.out.println();
		    System.out.println();
		}
		
		System.out.println();

		if(empate) {
			return "--------------- EMPATE ---------------\n\n" +
					"com a pontuação " + jogadorVencedor.getPontuacao() +
					"\n\n------------------------------------------------";
		} else 
			return "--------------- JOGADOR VENCEDOR ---------------\n\n" +
				jogadorVencedor.getNome() + " ganhou com a pontuação " + jogadorVencedor.getPontuacao() +
				"\n\n------------------------------------------------";
	}
	
	
	
	/*Adiciona 5 cartas para a mão do jogador 
	*e as retiram do baralho para não ser usadas duas vezes
	*/
	public void darCartas() {
		
		for(Jogador jogador : jogadores) {
			
			List<Carta> maoJogador = new ArrayList<Carta>();
			for(int i=1; i<=5; i++) {
				maoJogador.add(baralho.getCartas().remove(0));
			}
						
			jogador.setMao(maoJogador);
			
		}
	}
	
	/*
	 * Verifica a mão do Jogador seguindo cada regra na sequência
	 * 
	 */
	public PokerRegraEnum checarMao(List<Carta> maoJogador) {
		
		PokerRegraEnum melhorPontuacao = PokerRegraEnum.MAIOR_CARTA;
		
		if(checarPar(maoJogador))
			melhorPontuacao = PokerRegraEnum.PAR;
		if(checarDoisPares(maoJogador))
			melhorPontuacao = PokerRegraEnum.DOIS_PARES;
		if(checarTrinca(maoJogador))
			melhorPontuacao = PokerRegraEnum.TRINCA;
		if(checarStraight(maoJogador))
			melhorPontuacao = PokerRegraEnum.STRAIGHT;
		if(checarFlush(maoJogador))
			melhorPontuacao = PokerRegraEnum.FLUSH;
		if(checarFullHouse(maoJogador))
			melhorPontuacao = PokerRegraEnum.FULL_HOUSE;
		if(checarQuadra(maoJogador))
			melhorPontuacao = PokerRegraEnum.QUADRA;
		if(checarStraightFlush(maoJogador))
			melhorPontuacao = PokerRegraEnum.STRAIGHT_FLUSH;
		if(checarRoyalFlush(maoJogador))
			melhorPontuacao = PokerRegraEnum.ROYAL_FLUSH;
		
		return melhorPontuacao;
	}
	
	
	/*
	 * Pega maior Carta da lista
	 */
	public Carta checarMaiorCarta(List<Carta> cartas) {
		return Collections.max(cartas);
	}
	
	/*
	 * Verifica se existem cartas de valores iguais
	 * A lista é ordenada com o método sort()
	 * Comparando assim, sempre os indices seguintes  
	 */
	public int checarSeTemPar(List<Carta> cartas) {
		Collections.sort(cartas);
		int temPar = 0;
		
		for(int i=1; i<cartas.size(); i++) {
			if(cartas.get(i-1).getValor().getValorNumero() == 
					cartas.get(i).getValor().getValorNumero()) {
				temPar++;
			}
		}
		
		return temPar;
	}
	
	/*
	 * Verifica se existe um par
	 */
	public boolean checarPar(List<Carta> cartas) {
		boolean isPar = checarSeTemPar(cartas) == 1 ? true : false;
		return isPar;
	}
	
	/*
	 * Verifica se existem dois pares
	 */
	public boolean checarDoisPares(List<Carta> cartas) {
		boolean isDoiPares = checarSeTemPar(cartas) == 2 ? true : false;
		return isDoiPares;
	}
	
	/*
	 * Verifica se existem três cartas de valores iguais
	 * A lista é ordenada com o método sort()
	 * Comparando assim, as três opçoes de Trinca: 
	 * os três primeiros índices, os três do "meio" e os três últimos
	 */
	public boolean checarTrinca(List<Carta> cartas) {
		Collections.sort(cartas);
		boolean isTrinca = false;
		
		if(cartas.get(0).getValor().getValorNumero() == cartas.get(2).getValor().getValorNumero() ||
				cartas.get(1).getValor().getValorNumero() == cartas.get(3).getValor().getValorNumero() || 
				cartas.get(2).getValor().getValorNumero() == cartas.get(4).getValor().getValorNumero()) {
			isTrinca = true;
		}
		return isTrinca;
	}
	
	/*
	 * Verifica se existe sequência na lista
	 * A lista é ordenada com o método sort() e invertida com o método reverse()
	 * Sendo assim, os valores dos indíces são diminuidos de forma a dar UM no resultado
	 */
	public boolean checarStraight(List<Carta> cartas) {
		Collections.sort(cartas);
		Collections.reverse(cartas);
		boolean isStraight = true;
		
		for(int i=0; i<cartas.size()-1; i++) {
			if(cartas.get(i).getValor().getValorNumero() - 
					cartas.get(i+1).getValor().getValorNumero() != 1 ) {
				isStraight = false;
			}
		}
	
		return isStraight;
	}
	
	/*
	 * Verifica a lista com o objetivo de achar todos os Naipes iguais
	 */
	public boolean checarFlush(List<Carta> cartas) {
		boolean isFlush = true;
		
		for(int i=0; i<cartas.size()-1; i++) {
			if(!cartas.get(i).getNaipe().equals(cartas.get(i+1).getNaipe())) {
				isFlush = false;
			}
		}
		
		return isFlush;
	}
	
	/*
	 * Verifica uma Trinca e um Par
	 * A lista é ordenada com o método sort()
	 * Sendo assim, os possíveis meios:
	 * 3 primeiros índices (Trinca) e 2 últimos índices (Par) OU
	 * 2 primeiros índices (Par) e 3 últimos índices (Trinca)
	 */
	public boolean checarFullHouse(List<Carta> cartas) {
		Collections.sort(cartas);
		boolean isFullHouse = false;
		
		if(cartas.get(0).getValor().getValorNumero() == cartas.get(2).getValor().getValorNumero() &&
				cartas.get(3).getValor().getValorNumero() == cartas.get(4).getValor().getValorNumero() ||
				cartas.get(0).getValor().getValorNumero() == cartas.get(1).getValor().getValorNumero() &&
				cartas.get(2).getValor().getValorNumero() == cartas.get(4).getValor().getValorNumero()) {
			isFullHouse = true;
		}
		
		return isFullHouse;
	}
	
	/*
	 * Verifica se existe quatro cartas de valores iguais na sequência (Quadra)
	 * A lista é ordenada com o método sort()
	 * Sendo assim, os possíveis meios:
	 * 4 primeiros índices OU 4 últmimos índices
	 */
	public boolean checarQuadra(List<Carta> cartas) {
		Collections.sort(cartas);
		boolean isQuadra = false;
		
		if(cartas.get(0).getValor().getValorNumero() == cartas.get(3).getValor().getValorNumero() ||
				cartas.get(1).getValor().getValorNumero() == cartas.get(4).getValor().getValorNumero()) {
			isQuadra = true;
		}
		
		return isQuadra;
	}
	
	/*
	 * Verifica se a lista possiu Cartas com Valores consecutivos e do mesmo Naipe
	 * São usados os métodos já criados para regras de outros métodos checarFlush() e checarStraight()
	 */
	public boolean checarStraightFlush(List<Carta> cartas) {
		boolean isStraightFlush = false;
		
		if(checarFlush(cartas) && checarStraight(cartas)) {
			isStraightFlush = true;
		}
		
		return isStraightFlush;
	}
	
	/*
	 * Verifica se a lista possiu Cartas com Valores consecutivos (10,Valete,Rainha,Rei e Ás) e do mesmo Naipe
	 * É usado o método já criado para a regra checarFlush() 
	 */
	public boolean checarRoyalFlush(List<Carta> cartas) {
		Collections.sort(cartas);
		boolean isRoyalFlush = false;
		
		if(checarFlush(cartas) &&
			cartas.get(0).getValor().equals(ValorEnum.DEZ) &&
			cartas.get(1).getValor().equals(ValorEnum.VALETE) &&
			cartas.get(2).getValor().equals(ValorEnum.RAINHA) &&
			cartas.get(3).getValor().equals(ValorEnum.REI) &&
			cartas.get(4).getValor().equals(ValorEnum.AS)) {
				isRoyalFlush = true;
		}
		
		return isRoyalFlush;
	}
	
}
