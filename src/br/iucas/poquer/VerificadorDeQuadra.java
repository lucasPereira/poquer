package br.iucas.poquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class VerificadorDeQuadra implements VerificadorDeJogo {

	@Override
	public VerificacaoDeJogo verificar(List<Carta> cartas) {
		cartas = new ArrayList<>(cartas);
		List<List<Carta>> agrupamentosQuadra = new AgrupadorDeCartasPorValor(cartas).agrupar(4);
		if (!agrupamentosQuadra.isEmpty()) {
			List<Carta> quadra = agrupamentosQuadra.iterator().next();
			List<Carta> jogo = new ArrayList<>(5);
			jogo.addAll(quadra);
			cartas.removeAll(quadra);
			List<Carta> desempate = new SeletorDeCartasDeDesempate().selecionar(1, cartas);
			jogo.addAll(desempate);
			return new VerificacaoDeJogo(jogo);
		}
		return new VerificacaoDeJogo(Arrays.asList());
	}

}
