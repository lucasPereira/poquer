package br.iucas.poquer.testes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.iucas.poquer.Carta;
import br.iucas.poquer.OrdenadorDeListaDeCartasSuperiorDecrescente;
import br.iucas.poquer.Valor;

public class AgrupadorDeCartasPorValor {

	private Map<Valor, List<Carta>> agrupamentosPorValor;

	public AgrupadorDeCartasPorValor(List<Carta> cartas) {
		agrupamentosPorValor = clusterizar(cartas);
	}

	public List<List<Carta>> agrupar(Integer tamanhoDoAgrupamento) {
		List<List<Carta>> agrupamentosSelecionados = filtrar(agrupamentosPorValor, tamanhoDoAgrupamento);
		new OrdenadorDeListaDeCartasSuperiorDecrescente().ordenar(agrupamentosSelecionados);
		return agrupamentosSelecionados;
	}

	private List<List<Carta>> filtrar(Map<Valor, List<Carta>> agrupamentosPorValor, Integer tamanhoDoAgrupamento) {
		List<List<Carta>> agrupamentos = new LinkedList<>();
		for (List<Carta> agrupamento : agrupamentosPorValor.values()) {
			if (agrupamento.size() == tamanhoDoAgrupamento) {
				agrupamentos.add(agrupamento);
			}
		}
		return agrupamentos;
	}

	private Map<Valor, List<Carta>> clusterizar(List<Carta> cartas) {
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
