package br.iucas.poquer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenadorDeListaDeCartasSuperiorDecrescente implements Comparator<List<Carta>> {

	private OrdenadorDeCartasSuperiorDecrescente ordenador;

	public OrdenadorDeListaDeCartasSuperiorDecrescente() {
		ordenador = new OrdenadorDeCartasSuperiorDecrescente();
	}

	@Override
	public int compare(List<Carta> cartas1, List<Carta> cartas2) {
		if (cartas1.isEmpty() && cartas2.isEmpty()) {
			return 0;
		} else if (cartas1.isEmpty() && !cartas2.isEmpty()) {
			return 1;
		} else if (!cartas1.isEmpty() && cartas2.isEmpty()) {
			return -1;
		}
		return ordenador.compare(cartas1.get(0), cartas2.get(0));
	}

	public void ordenar(List<List<Carta>> sequencias) {
		for (List<Carta> sequencia : sequencias) {
			ordenador.ordenar(sequencia);
		}
		Collections.sort(sequencias, this);
	}

}
