package desafio.locker.poker.modelos;

public enum PokerRegraEnum {

	MAIOR_CARTA(1),
	PAR(2),
	DOIS_PARES(3),
	TRINCA(4),
	STRAIGHT(5),
	FLUSH(6),
	FULL_HOUSE(7),
	QUADRA(8),
	STRAIGHT_FLUSH(9),
	ROYAL_FLUSH(10);
	  
	private int valor;
	private int numeroCartaSignificante;
	  
	private PokerRegraEnum(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public int getNumeroCartaSignificante() {
		return numeroCartaSignificante;
	}
	  
}
