package br.iucas.poquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerificadorDePar implements VerificadorDeJogo {

	public VerificadorDePar() {}

	@Override
	public VerificacaoDeJogo verificar(List<Carta> cartas) {
		cartas = new ArrayList<>(cartas);
		List<List<Carta>> agrupamentosComPares = new AgrupadorDeCartasPorValor(cartas).agrupar(2);
		if (!agrupamentosComPares.isEmpty()) {
			List<Carta> par = agrupamentosComPares.iterator().next();
			List<Carta> jogo = new ArrayList<>(5);
			jogo.addAll(par);
			cartas.removeAll(par);
			List<Carta> desempate = new SeletorDeCartasDeDesempate().selecionar(3, cartas);
			jogo.addAll(desempate);
			return new VerificacaoDeJogo(jogo);
		}
		return new VerificacaoDeJogo(Arrays.asList());
	}

}
