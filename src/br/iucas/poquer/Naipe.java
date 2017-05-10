package br.iucas.poquer;

public class Naipe {

	private Character simbolo;

	public Naipe(Character simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Naipe) {
			Naipe naipe = (Naipe) objeto;
			return simbolo.equals(naipe.simbolo);
		}
		return super.equals(objeto);
	}

	@Override
	public String toString() {
		return simbolo.toString();
	}

	public Boolean maiorQue(Naipe naipe) {
		return (int) simbolo < (int) naipe.simbolo;
	}

}
