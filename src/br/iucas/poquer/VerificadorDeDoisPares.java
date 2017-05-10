package br.iucas.poquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VerificadorDeDoisPares implements VerificadorDeJogo {

	@Override
	public VerificacaoDeJogo verificar(List<Carta> cartas) {
		cartas = new ArrayList<>(cartas);
		List<List<Carta>> agrupamentosComPares = new AgrupadorDeCartasPorValor(cartas).agrupar(2);
		if (agrupamentosComPares.size() >= 2) {
			Iterator<List<Carta>> pares = agrupamentosComPares.iterator();
			List<Carta> par1 = pares.next();
			List<Carta> par2 = pares.next();
			List<Carta> jogo = new ArrayList<>(5);
			jogo.addAll(par1);
			jogo.addAll(par2);
			cartas.removeAll(par1);
			cartas.removeAll(par2);
			List<Carta> desempate = new SeletorDeCartasDeDesempate().selecionar(1, cartas);
			jogo.addAll(desempate);
			return new VerificacaoDeJogo(jogo);
		}
		return new VerificacaoDeJogo(Arrays.asList());
	}

}
