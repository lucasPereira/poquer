package br.iucas.poquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AgrupadorDeCartasPorValor implements AgrupadorDeCartas {

	private Map<Valor, List<Carta>> agrupamentosPorValor;

	public AgrupadorDeCartasPorValor(List<Carta> cartas) {
		agrupamentosPorValor = clusterizar(cartas);
	}

	@Override
	public List<List<Carta>> agrupar(Integer tamanho) {
		List<List<Carta>> agrupamentosSelecionados = new ArrayList<>(agrupamentosPorValor.values());
		agrupamentosSelecionados.removeIf(agrupamento -> agrupamento.size() != tamanho);
		new OrdenadorDeListaPorCartaAlta().ordenar(agrupamentosSelecionados);
		return agrupamentosSelecionados;
	}

	private Map<Valor, List<Carta>> clusterizar(List<Carta> cartas) {
		Map<Valor, List<Carta>> agrupamentos = new HashMap<>();
		for (Carta carta : cartas) {
			Valor valor = carta.obterValor();
			agrupamentos.computeIfAbsent(valor, chave -> new LinkedList<>());
			agrupamentos.computeIfPresent(valor, (chave, agrupamento) -> {
				agrupamento.add(carta);
				return agrupamento;
			});
		}
		return agrupamentos;
	}

}
