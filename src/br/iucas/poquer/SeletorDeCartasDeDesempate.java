package br.iucas.poquer;

import java.util.List;

public class SeletorDeCartasDeDesempate {

	public List<Carta> selecionar(Integer quantidade, List<Carta> cartas) {
		new OrdenadorDeCartaAlta().ordenar(cartas);
		Integer ultimo = cartas.size() >= quantidade ? quantidade : cartas.size(); 
		return cartas.subList(0, ultimo);
	}

}
