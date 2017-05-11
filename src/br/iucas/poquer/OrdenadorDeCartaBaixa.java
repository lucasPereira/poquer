package br.iucas.poquer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenadorDeCartaBaixa implements Comparator<Carta> {

	@Override
	public int compare(Carta carta1, Carta carta2) {
		Valor valor1 = carta1.obterValor();
		Valor valor2 = carta2.obterValor();
		if (valor1.equals(valor2)) {
			Naipe naipe1 = carta1.obterNaipe();
			Naipe naipe2 = carta2.obterNaipe();
			if (naipe1.equals(naipe2)) {
				return 0;
			}
			return naipe1.maiorQue(naipe2) ? -1 : 0;
		}
		return valor1.inferiorMaiorQue(valor2) ? -1 : 0;
	}

	public void ordenar(List<Carta> cartas) {
		Collections.sort(cartas, this);
	}

}
