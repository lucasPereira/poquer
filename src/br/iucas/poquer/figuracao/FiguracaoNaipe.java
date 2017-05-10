package br.iucas.poquer.figuracao;

import br.iucas.poquer.Naipe;

public class FiguracaoNaipe {

	public Naipe espadas() {
		return new Naipe('♠');
	}

	public Naipe copas() {
		return new Naipe('♥');
	}

	public Naipe paus() {
		return new Naipe('♣');
	}

	public Naipe ouro() {
		return new Naipe('♦');
	}

}
