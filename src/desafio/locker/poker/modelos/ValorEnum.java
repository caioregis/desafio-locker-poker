package desafio.locker.poker.modelos;

public enum ValorEnum {
	
	DOIS(2),
	TRES(3),
	QUATRO(4),
	CINCO(5),
	SEIS(6),
	SETE(7),
	OITO(8),
	NOVE(9),
	DEZ(10),
	VALETE(11),
	RAINHA(12),
	REI(13),
	AS(14);

	private int numeroValor;
	
	private ValorEnum(int _valor) {
		this.numeroValor = _valor;
	}
	
	public int getValorNumero() {
		return this.numeroValor;
	}
}


