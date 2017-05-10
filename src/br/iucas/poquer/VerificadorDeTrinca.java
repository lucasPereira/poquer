package br.iucas.poquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VerificadorDeTrinca implements VerificadorDeJogo {

	@Override
	public VerificacaoDeJogo verificar(List<Carta> cartas) {
		cartas = new ArrayList<>(cartas);
		Map<Valor, List<Carta>> agrupamentosPorValor = criarAgrupamentosPorValor(cartas);
		List<List<Carta>> agrupamentosComTrincas = selecionarAgrupamentosDePares(agrupamentosPorValor);
		new OrdenadorDeListaDeCartasSuperiorDecrescente().ordenar(agrupamentosComTrincas);
		if (!agrupamentosComTrincas.isEmpty()) {
			List<Carta> jogo = new ArrayList<>(5);
			Iterator<Carta> par = agrupamentosComTrincas.iterator().next().iterator();
			Carta parItem1 = par.next();
			Carta parItem2 = par.next();
			Carta parItem3 = par.next();
			jogo.add(parItem1);
			jogo.add(parItem2);
			jogo.add(parItem3);
			cartas.remove(parItem1);
			cartas.remove(parItem2);
			cartas.remove(parItem3);
			new OrdenadorDeCartasSuperiorDecrescente().ordenar(cartas);
			Integer contador = 0;
			Iterator<Carta> desempate = cartas.iterator();
			while (contador < 2 && desempate.hasNext()) {
				jogo.add(desempate.next());
				contador++;
			}
			return new VerificacaoDeJogo(jogo);
		}
		return new VerificacaoDeJogo(Arrays.asList());
	}

	private List<List<Carta>> selecionarAgrupamentosDePares(Map<Valor, List<Carta>> agrupamentosPorValor) {
		List<List<Carta>> agrupamentosComPares = new LinkedList<>();
		for (List<Carta> agrupamento : agrupamentosPorValor.values()) {
			if (agrupamento.size() == 3) {
				agrupamentosComPares.add(agrupamento);
			}
		}
		return agrupamentosComPares;
	}

	private Map<Valor, List<Carta>> criarAgrupamentosPorValor(List<Carta> cartas) {
		Map<Valor, List<Carta>> agrupamentos = new HashMap<>();
		for (Carta carta : cartas) {
			Valor valor = carta.obterValor();
			if (!agrupamentos.containsKey(valor)) {
				agrupamentos.put(valor, new LinkedList<>());
			}
			agrupamentos.get(valor).add(carta);
		}
		return agrupamentos;
	}

}
