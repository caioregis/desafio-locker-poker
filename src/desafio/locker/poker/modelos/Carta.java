package desafio.locker.poker.modelos;

public class Carta implements Comparable<Carta> {
	
	private ValorEnum valor;
	private NaipeEnum naipe;
	
	public Carta(ValorEnum valor, NaipeEnum naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}

	public NaipeEnum getNaipe() {
		return naipe;
	}

	public void setValor(ValorEnum valor) {
		this.valor = valor;
	}

	public void setNaipe(NaipeEnum naipe) {
		this.naipe = naipe;
	}

	public ValorEnum getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "[" + valor + " de " + naipe + "]";
	}
	
	
	/*
	compara valores das cartas
	retorna negativo caso seja menor
 	retorna 0 caso seja igual
	retorna positivo caso seja maior
	*/
	public int compareTo(Carta c) {
		//regra implementada pelo valor
		int comparar = this.valor.compareTo(c.valor);
		if(comparar != 0) {
			//maior ou menor
			return comparar;
		}
		//igual
		return 0;
	}
}
