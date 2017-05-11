package br.iucas.poquer.figuracao;

import br.iucas.poquer.Valor;

public class FiguracaoValor {

	public Valor as() {
		return new Valor("A", 1, 14);
	}

	public Valor rei() {
		return new Valor("K", 13, 13);
	}

	public Valor dama() {
		return new Valor("Q", 12, 12);
	}

	public Valor valete() {
		return new Valor("J", 11, 11);
	}

	public Valor dez() {
		return new Valor("10", 10, 10);
	}

	public Valor nove() {
		return new Valor("9", 9, 9);
	}

	public Valor oito() {
		return new Valor("8", 8, 8);
	}

	public Valor seis() {
		return new Valor("6", 6, 6);
	}

	public Valor cinco() {
		return new Valor("5", 5, 5);
	}

	public Valor quatro() {
		return new Valor("4", 4, 4);
	}

	public Valor tres() {
		return new Valor("3", 3, 3);
	}

	public Valor dois() {
		return new Valor("2", 2, 2);
	}

}
