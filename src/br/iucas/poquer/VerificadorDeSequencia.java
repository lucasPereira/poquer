package br.iucas.poquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VerificadorDeSequencia implements VerificadorDeJogo {

	@Override
	public VerificacaoDeJogo verificar(List<Carta> cartas) {
		cartas = new ArrayList<>(cartas);
		OrdenadorDeCartaAlta ordenadorAlto = new OrdenadorDeCartaAlta();
		OrdenadorDeCartaBaixa ordenadorBaixo = new OrdenadorDeCartaBaixa();
		ordenadorAlto.ordenar(cartas);
		List<Carta> sequenciaAlta = verificarSequencia(cartas);
		if (sequenciaAlta.size() == 5) {
			return new VerificacaoDeJogo(sequenciaAlta);
		}
		ordenadorBaixo.ordenar(cartas);
		List<Carta> sequenciaBaixa = verificarSequencia(cartas);
		if (sequenciaBaixa.size() == 5) {
			return new VerificacaoDeJogo(sequenciaBaixa);
		}
		ordenadorBaixo.ordenar(cartas);
		return new VerificacaoDeJogo(Arrays.asList());
	}

	private List<Carta> verificarSequencia(List<Carta> cartas) {
		List<Carta> jogo = new ArrayList<>(5);
		Iterator<Carta> iterador = cartas.iterator();
		if (iterador.hasNext()) {
			jogo.add(iterador.next());
		}
		while (iterador.hasNext() && jogo.size() < 5) {
			Boolean pulou = false;
			while (iterador.hasNext() && !pulou && jogo.size() < 5) {
				Carta sucessora = jogo.get(jogo.size() - 1);
				Carta atual = iterador.next();
				if (!sucessora.obterValor().sucessor(atual.obterValor())) {
					jogo.clear();
					pulou = true;
				}
				jogo.add(atual);
			}
		}
		return jogo;
	}

}
