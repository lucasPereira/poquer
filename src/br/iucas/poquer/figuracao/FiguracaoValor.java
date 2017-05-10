package br.iucas.poquer.figuracao;

import br.iucas.poquer.Valor;

public class FiguracaoValor {

	public Valor as() {
		return new Valor("A", 1, 14);
	}

	public Valor rei() {
		return new Valor("K", 13, 13);
	}

	public Valor dez() {
		return new Valor("10", 10, 10);
	}

	public Valor oito() {
		return new Valor("8", 8, 8);
	}

	public Valor seis() {
		return new Valor("6", 6, 6);
	}

	public Valor dois() {
		return new Valor("2", 2, 2);
	}

}
