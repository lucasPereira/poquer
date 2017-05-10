package br.iucas.poquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerificadorDeFlush implements VerificadorDeJogo {

	@Override
	public VerificacaoDeJogo verificar(List<Carta> cartas) {
		cartas = new ArrayList<>(cartas);
		AgrupadorDeCartasPorNaipe agrupador = new AgrupadorDeCartasPorNaipe(cartas);
		List<List<Carta>> agrupamentosComMesmoNaipe = agrupador.agrupar(5);
		if (!agrupamentosComMesmoNaipe.isEmpty()) {
			List<Carta> jogo = new ArrayList<>(5);
			List<Carta> maiorFlush = agrupamentosComMesmoNaipe.iterator().next();
			jogo.addAll(maiorFlush.subList(0, 5));
			return new VerificacaoDeJogo(jogo);
		}
		return new VerificacaoDeJogo(Arrays.asList());
	}

}
