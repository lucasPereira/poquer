package br.iucas.poquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VerificadorDePar {

	public VerificadorDePar() {}

	public VerificacaoDeJogo verificar(List<Carta> cartas) {
		cartas = new ArrayList<>(cartas);
		Map<Valor, List<Carta>> agrupamentosPorValor = criarAgrupamentosPorValor(cartas);
		List<List<Carta>> agrupamentosComPares = selecionarAgrupamentosDePares(agrupamentosPorValor);
		new OrdenadorDeListaSuperiorDecrescente().ordenar(agrupamentosComPares);
		if (!agrupamentosComPares.isEmpty()) {
			List<Carta> jogo = new ArrayList<>(5);
			Iterator<Carta> par = agrupamentosComPares.iterator().next().iterator();
			Carta parItem1 = par.next();
			Carta parItem2 = par.next();
			jogo.add(parItem1);
			jogo.add(parItem2);
			cartas.remove(parItem1);
			cartas.remove(parItem2);
			new OrdenadorSuperiorDecrescente().ordenar(cartas);
			Integer contador = 0;
			Iterator<Carta> iteradorDeCartasDeDesempate = cartas.iterator();
			while (contador < 3 && iteradorDeCartasDeDesempate.hasNext()) {
				jogo.add(iteradorDeCartasDeDesempate.next());
				contador++;
			}
			return new VerificacaoDeJogo(jogo);
		}
		return new VerificacaoDeJogo(Arrays.asList());
	}

	private List<List<Carta>> selecionarAgrupamentosDePares(Map<Valor, List<Carta>> agrupamentosPorValor) {
		List<List<Carta>> agrupamentosComPares = new LinkedList<>();
		for (List<Carta> agrupamento : agrupamentosPorValor.values()) {
			if (agrupamento.size() == 2) {
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
