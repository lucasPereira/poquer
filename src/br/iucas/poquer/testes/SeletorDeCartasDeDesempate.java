package br.iucas.poquer.testes;

import java.util.List;

import br.iucas.poquer.Carta;
import br.iucas.poquer.OrdenadorDeCartasSuperiorDecrescente;

public class SeletorDeCartasDeDesempate {

	public List<Carta> selecionar(Integer quantidade, List<Carta> cartas) {
		new OrdenadorDeCartasSuperiorDecrescente().ordenar(cartas);
		Integer ultimo = cartas.size() >= quantidade ? quantidade : cartas.size(); 
		return cartas.subList(0, ultimo);
	}

}
