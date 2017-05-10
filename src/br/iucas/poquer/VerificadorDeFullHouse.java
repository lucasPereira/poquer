package br.iucas.poquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerificadorDeFullHouse implements VerificadorDeJogo {

	@Override
	public VerificacaoDeJogo verificar(List<Carta> cartas) {
		cartas = new ArrayList<>(cartas);
		AgrupadorDeCartasPorValor agrupador = new AgrupadorDeCartasPorValor(cartas);
		List<List<Carta>> agrupamentosComTrincas = agrupador.agrupar(3);
		List<List<Carta>> agrupamentosComPares = agrupador.agrupar(2);
		if (!agrupamentosComTrincas.isEmpty() && !agrupamentosComPares.isEmpty()) {
			List<Carta> jogo = new ArrayList<>(5);
			List<Carta> trinca = agrupamentosComTrincas.iterator().next();
			List<Carta> par = agrupamentosComPares.iterator().next();
			jogo.addAll(trinca);
			jogo.addAll(par);
			return new VerificacaoDeJogo(jogo);
		}
		return new VerificacaoDeJogo(Arrays.asList());
	}

}
