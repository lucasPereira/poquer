package br.iucas.poquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AgrupadorDeCartasPorNaipe implements AgrupadorDeCartas {

	private Map<Naipe, List<Carta>> agrupamentosPorNaipe;

	public AgrupadorDeCartasPorNaipe(List<Carta> cartas) {
		agrupamentosPorNaipe = clusterizar(cartas);
	}

	@Override
	public List<List<Carta>> agrupar(Integer tamanhoMinimo) {
		List<List<Carta>> agrupamentosSelecionados = new ArrayList<>(agrupamentosPorNaipe.values());
		agrupamentosSelecionados.removeIf(agrupamento -> agrupamento.size() < tamanhoMinimo);
		new OrdenadorDeListaPorCartaAlta().ordenar(agrupamentosSelecionados);
		return agrupamentosSelecionados;
	}

	private Map<Naipe, List<Carta>> clusterizar(List<Carta> cartas) {
		Map<Naipe, List<Carta>> agrupamentos = new HashMap<>();
		for (Carta carta : cartas) {
			Naipe naipe = carta.obterNaipe();
			agrupamentos.computeIfAbsent(naipe, chave -> new LinkedList<>());
			agrupamentos.computeIfPresent(naipe, (chave, valor) -> {
				valor.add(carta);
				return valor;
			});
		}
		return agrupamentos;
	}

}
