package desafio.locker.poker.modelos;

public enum NaipeEnum {

	OURO(1),
	COPAS(2),
	ESPADAS(3),
	PAUS(4);
	
	private int naipeValor;
	
	private NaipeEnum(int _naipeValor) {
		this.naipeValor = _naipeValor; 
	}
	
	public int getNaipeValor() {
		return this.naipeValor;
	}
}
