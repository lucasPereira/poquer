package br.iucas.poquer;

public class Carta {

	private Valor valor;
	private Naipe naipe;

	public Carta(Valor valor, Naipe naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}

	public Valor obterValor() {
		return valor;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Carta) {
			Carta carta = (Carta) objeto;
			return valor.equals(carta.valor) && naipe.equals(carta.naipe);
		}
		return super.equals(objeto);
	}

	@Override
	public String toString() {
		return String.format("%s%s", valor, naipe);
	}

	public Naipe obterNaipe() {
		return naipe;
	}

}
