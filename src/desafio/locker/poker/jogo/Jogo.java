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
	 * D� as cartas para os jogadores
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
	 * Checa e pontua a m�o de cada Jogador
	 * Compara as pontua��es
	 * Determina o Vencedor do Jogo
	 */
	public String determinarVencedor() {
		
		Jogador jogadorVencedor = null;
		int pontuacaoVencedora = 0;
		List<Carta> melhoresCartas = null;
		boolean empate = false;
		
		for(Jogador jogador : jogadores) {
			jogador.setPontuacao(checarMao(jogador.getMao()));
			
			//Se a pontua��o do atual � maior que a antiga, atualiza o vencedor
			if(jogador.getPontuacao().getValor() > pontuacaoVencedora) {
				jogadorVencedor = jogador;
				pontuacaoVencedora = jogador.getPontuacao().getValor();
				melhoresCartas = jogador.getMao();
				empate = false;
			} 
			//Se a pontua��o do atual � igual da antiga, vence a m�o formada pelas cartas de maior valor. 
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
					"com a pontua��o " + jogadorVencedor.getPontuacao() +
					"\n\n------------------------------------------------";
		} else 
			return "--------------- JOGADOR VENCEDOR ---------------\n\n" +
				jogadorVencedor.getNome() + " ganhou com a pontua��o " + jogadorVencedor.getPontuacao() +
				"\n\n------------------------------------------------";
	}
	
	
	
	/*Adiciona 5 cartas para a m�o do jogador 
	*e as retiram do baralho para n�o ser usadas duas vezes
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
	 * Verifica a m�o do Jogador seguindo cada regra na sequ�ncia
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
	 * A lista � ordenada com o m�todo sort()
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
	 * Verifica se existem tr�s cartas de valores iguais
	 * A lista � ordenada com o m�todo sort()
	 * Comparando assim, as tr�s op�oes de Trinca: 
	 * os tr�s primeiros �ndices, os tr�s do "meio" e os tr�s �ltimos
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
	 * Verifica se existe sequ�ncia na lista
	 * A lista � ordenada com o m�todo sort() e invertida com o m�todo reverse()
	 * Sendo assim, os valores dos ind�ces s�o diminuidos de forma a dar UM no resultado
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
	 * A lista � ordenada com o m�todo sort()
	 * Sendo assim, os poss�veis meios:
	 * 3 primeiros �ndices (Trinca) e 2 �ltimos �ndices (Par) OU
	 * 2 primeiros �ndices (Par) e 3 �ltimos �ndices (Trinca)
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
	 * Verifica se existe quatro cartas de valores iguais na sequ�ncia (Quadra)
	 * A lista � ordenada com o m�todo sort()
	 * Sendo assim, os poss�veis meios:
	 * 4 primeiros �ndices OU 4 �ltmimos �ndices
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
	 * S�o usados os m�todos j� criados para regras de outros m�todos checarFlush() e checarStraight()
	 */
	public boolean checarStraightFlush(List<Carta> cartas) {
		boolean isStraightFlush = false;
		
		if(checarFlush(cartas) && checarStraight(cartas)) {
			isStraightFlush = true;
		}
		
		return isStraightFlush;
	}
	
	/*
	 * Verifica se a lista possiu Cartas com Valores consecutivos (10,Valete,Rainha,Rei e �s) e do mesmo Naipe
	 * � usado o m�todo j� criado para a regra checarFlush() 
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
