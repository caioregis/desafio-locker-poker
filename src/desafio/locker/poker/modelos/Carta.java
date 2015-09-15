package desafio.locker.poker.modelos;

public class Carta implements Comparable<Carta> {
	
	private Valor valor;
	private Naipe naipe;
	
	public Carta(Valor valor, Naipe naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}

	public Naipe getNaipe() {
		return naipe;
	}

	public Valor getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "[" + valor + " de " + naipe + "]" + "\n";
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
