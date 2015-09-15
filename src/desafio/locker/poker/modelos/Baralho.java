package desafio.locker.poker.modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {

	private List<Carta> cartas = new ArrayList<Carta>();
	
	//Gera o baralho a partir dos valores e naipes 
	public Baralho() {
		
		for(Naipe naipe : Naipe.values()) {
			
			for(Valor valor : Valor.values()) {
				Carta carta = new Carta(valor, naipe);
				cartas.add(carta);
			}
		}
	}

	public List<Carta> getCartas() {
		return cartas;
	}
	
	//Metodo para embaralhar o baralho
	public void embaralhar() {
		Collections.shuffle(cartas);
	}
		
}
