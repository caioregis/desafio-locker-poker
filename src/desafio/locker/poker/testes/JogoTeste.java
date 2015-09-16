package desafio.locker.poker.testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import desafio.locker.poker.jogo.Jogo;
import desafio.locker.poker.modelos.Carta;
import desafio.locker.poker.modelos.NaipeEnum;
import desafio.locker.poker.modelos.PokerRegraEnum;
import desafio.locker.poker.modelos.ValorEnum;

public class JogoTeste {

	@Before
	public void setUp() throws Exception {
	}

	Jogo j = new Jogo();
	
	@Test
	public void detectarMaiorCarta() {
	    
		List<Carta> mao = new ArrayList<Carta>();
		    
		mao.add(new Carta(ValorEnum.NOVE, NaipeEnum.COPAS));
		mao.add(new Carta(ValorEnum.TRES, NaipeEnum.ESPADAS));
		mao.add(new Carta(ValorEnum.OITO, NaipeEnum.OURO));
		mao.add(new Carta(ValorEnum.REI, NaipeEnum.PAUS));
		mao.add(new Carta(ValorEnum.DOIS, NaipeEnum.ESPADAS));
		    
		PokerRegraEnum pokerRegra = j.checarMao(mao);
		    
		assertEquals(PokerRegraEnum.MAIOR_CARTA.getValor(), pokerRegra.getValor());
		assertEquals(ValorEnum.REI, mao.get(4).getValor());
	}
	
	@Test
	public void detectarParDeSete() {
		
		List<Carta> mao = new ArrayList<Carta>();
	    
		mao.add(new Carta(ValorEnum.NOVE, NaipeEnum.COPAS));
		mao.add(new Carta(ValorEnum.SETE, NaipeEnum.ESPADAS));
		mao.add(new Carta(ValorEnum.SETE, NaipeEnum.OURO));
		mao.add(new Carta(ValorEnum.REI, NaipeEnum.PAUS));
		mao.add(new Carta(ValorEnum.DOIS, NaipeEnum.ESPADAS));
		    
		PokerRegraEnum pokerRegra = j.checarMao(mao);
		
		assertEquals(PokerRegraEnum.PAR.getValor(), pokerRegra.getValor());
		assertEquals(ValorEnum.SETE, mao.get(1).getValor());
		assertEquals(ValorEnum.SETE, mao.get(2).getValor());

	}
	
	@Test
	public void detectarTresAses() {
		
		List<Carta> mao = new ArrayList<Carta>();
	    
		mao.add(new Carta(ValorEnum.AS, NaipeEnum.COPAS));
		mao.add(new Carta(ValorEnum.SETE, NaipeEnum.ESPADAS));
		mao.add(new Carta(ValorEnum.DOIS, NaipeEnum.OURO));
		mao.add(new Carta(ValorEnum.AS, NaipeEnum.PAUS));
		mao.add(new Carta(ValorEnum.AS, NaipeEnum.ESPADAS));
		    
		PokerRegraEnum pokerRegra = j.checarMao(mao);

		assertEquals(PokerRegraEnum.TRINCA.getValor(), pokerRegra.getValor());
		//Teste de indice passa porque no método checarTrinca a lista é ordenada 
		assertEquals(ValorEnum.AS, mao.get(2).getValor());
		assertEquals(ValorEnum.AS, mao.get(3).getValor());
		assertEquals(ValorEnum.AS, mao.get(4).getValor());

	}
	
	@Test
	public void detectarDoisValetesDuasDamas() {
		
		List<Carta> mao = new ArrayList<Carta>();
	    
		mao.add(new Carta(ValorEnum.VALETE, NaipeEnum.COPAS));
		mao.add(new Carta(ValorEnum.RAINHA, NaipeEnum.ESPADAS));
		mao.add(new Carta(ValorEnum.RAINHA, NaipeEnum.OURO));
		mao.add(new Carta(ValorEnum.AS, NaipeEnum.PAUS));
		mao.add(new Carta(ValorEnum.VALETE, NaipeEnum.ESPADAS));
		    
		PokerRegraEnum pokerRegra = j.checarMao(mao);

		assertEquals(PokerRegraEnum.DOIS_PARES.getValor(), pokerRegra.getValor());
		//Teste de indice passa porque no método checarDoisPares a lista é ordenada 
		assertEquals(ValorEnum.RAINHA, mao.get(2).getValor());
		assertEquals(ValorEnum.RAINHA, mao.get(3).getValor());
		assertEquals(ValorEnum.VALETE, mao.get(0).getValor());
		assertEquals(ValorEnum.VALETE, mao.get(1).getValor());

	}
	
	@Test
	public void detectarFullHouse() {
		
		List<Carta> mao = new ArrayList<Carta>();
	    
		mao.add(new Carta(ValorEnum.VALETE, NaipeEnum.COPAS));
		mao.add(new Carta(ValorEnum.RAINHA, NaipeEnum.ESPADAS));
		mao.add(new Carta(ValorEnum.RAINHA, NaipeEnum.OURO));
		mao.add(new Carta(ValorEnum.RAINHA, NaipeEnum.PAUS));
		mao.add(new Carta(ValorEnum.VALETE, NaipeEnum.ESPADAS));
		    
		PokerRegraEnum pokerRegra = j.checarMao(mao);

		assertEquals(PokerRegraEnum.FULL_HOUSE.getValor(), pokerRegra.getValor());
		//Teste de indice passa porque no método checarDoisPares a lista é ordenada 
		assertEquals(ValorEnum.RAINHA, mao.get(2).getValor());
		assertEquals(ValorEnum.RAINHA, mao.get(3).getValor());
		assertEquals(ValorEnum.VALETE, mao.get(0).getValor());
		assertEquals(ValorEnum.VALETE, mao.get(1).getValor());
		assertEquals(ValorEnum.RAINHA, mao.get(4).getValor());

	}
	
	@Test
	public void detectarQuatroReis() {
		
		List<Carta> mao = new ArrayList<Carta>();
	    
		mao.add(new Carta(ValorEnum.REI, NaipeEnum.COPAS));
		mao.add(new Carta(ValorEnum.RAINHA, NaipeEnum.ESPADAS));
		mao.add(new Carta(ValorEnum.REI, NaipeEnum.OURO));
		mao.add(new Carta(ValorEnum.REI, NaipeEnum.PAUS));
		mao.add(new Carta(ValorEnum.REI, NaipeEnum.ESPADAS));
		    
		PokerRegraEnum pokerRegra = j.checarMao(mao);

		assertEquals(PokerRegraEnum.QUADRA.getValor(), pokerRegra.getValor());
		//Teste de indice passa porque no método checarDoisPares a lista é ordenada 
		assertEquals(ValorEnum.REI, mao.get(2).getValor());
		assertEquals(ValorEnum.RAINHA, mao.get(0).getValor());
		assertEquals(ValorEnum.REI, mao.get(3).getValor());
		assertEquals(ValorEnum.REI, mao.get(1).getValor());
		assertEquals(ValorEnum.REI, mao.get(4).getValor());

	}
	
	@Test
	public void detectarSeteStraight() {
		
		List<Carta> mao = new ArrayList<Carta>();
	    
		mao.add(new Carta(ValorEnum.SEIS, NaipeEnum.COPAS));
		mao.add(new Carta(ValorEnum.SETE, NaipeEnum.ESPADAS));
		mao.add(new Carta(ValorEnum.QUATRO, NaipeEnum.OURO));
		mao.add(new Carta(ValorEnum.TRES, NaipeEnum.PAUS));
		mao.add(new Carta(ValorEnum.CINCO, NaipeEnum.ESPADAS));
		    
		PokerRegraEnum pokerRegra = j.checarMao(mao);

		assertEquals(PokerRegraEnum.STRAIGHT.getValor(), pokerRegra.getValor());
		//Teste de indice passa porque no método checarStraight a lista é ordenada 
		assertEquals(ValorEnum.TRES, mao.get(0).getValor());
		assertEquals(ValorEnum.QUATRO, mao.get(1).getValor());
		assertEquals(ValorEnum.CINCO, mao.get(2).getValor());
		assertEquals(ValorEnum.SEIS, mao.get(3).getValor());
		assertEquals(ValorEnum.SETE, mao.get(4).getValor());

	}
	

}
