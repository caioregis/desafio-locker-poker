package desafio.locker.poker.modelos;

import java.util.List;

public class Jogador {
	
	private String nome;
	private List<Carta> mao;
	
	public List<Carta> getMao() {
		return mao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMao(List<Carta> mao) {
		this.mao = mao;
	}

	public Jogador(String nome) {
		this.nome = nome;
	}
}
