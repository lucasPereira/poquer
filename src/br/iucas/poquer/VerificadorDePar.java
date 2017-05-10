package br.iucas.poquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import br.iucas.poquer.testes.AgrupadorDeCartasPorValor;

public class VerificadorDePar implements VerificadorDeJogo {

	public VerificadorDePar() {}

	@Override
	public VerificacaoDeJogo verificar(List<Carta> cartas) {
		cartas = new ArrayList<>(cartas);
		List<List<Carta>> agrupamentosComPares = new AgrupadorDeCartasPorValor(cartas).agrupar(2);
		if (!agrupamentosComPares.isEmpty()) {
			List<Carta> jogo = new ArrayList<>(5);
			Iterator<Carta> par = agrupamentosComPares.iterator().next().iterator();
			Carta parItem1 = par.next();
			Carta parItem2 = par.next();
			jogo.add(parItem1);
			jogo.add(parItem2);
			cartas.remove(parItem1);
			cartas.remove(parItem2);
			new OrdenadorDeCartasSuperiorDecrescente().ordenar(cartas);
			Integer contador = 0;
			Iterator<Carta> desempate = cartas.iterator();
			while (contador < 3 && desempate.hasNext()) {
				jogo.add(desempate.next());
				contador++;
			}
			return new VerificacaoDeJogo(jogo);
		}
		return new VerificacaoDeJogo(Arrays.asList());
	}

}
