package br.iucas.poquer;

import java.util.List;

public class VerificacaoDeJogo {

	private List<Carta> jogo;

	public VerificacaoDeJogo(List<Carta> jogo) {
		this.jogo = jogo;
	}

	public Boolean valido() {
		return !jogo.isEmpty();
	}

	public List<Carta> jogo() {
		return jogo;
	}

}
