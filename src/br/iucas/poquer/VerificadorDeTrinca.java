package br.iucas.poquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerificadorDeTrinca implements VerificadorDeJogo {

	@Override
	public VerificacaoDeJogo verificar(List<Carta> cartas) {
		cartas = new ArrayList<>(cartas);
		List<List<Carta>> agrupamentosComTrincas = new AgrupadorDeCartasPorValor(cartas).agrupar(3);
		if (!agrupamentosComTrincas.isEmpty()) {
			List<Carta> trinca = agrupamentosComTrincas.iterator().next();
			List<Carta> jogo = new ArrayList<>(5);
			jogo.addAll(trinca);
			cartas.removeAll(trinca);
			List<Carta> desempate = new SeletorDeCartasDeDesempate().selecionar(2, cartas);
			jogo.addAll(desempate);
			return new VerificacaoDeJogo(jogo);
		}
		return new VerificacaoDeJogo(Arrays.asList());
	}

}
