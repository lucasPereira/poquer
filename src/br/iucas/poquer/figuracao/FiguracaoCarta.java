package br.iucas.poquer.figuracao;

import br.iucas.poquer.Carta;

public class FiguracaoCarta {

	private FiguracaoValor figuracaoValor;
	private FiguracaoNaipe figuracaoNaipe;

	public FiguracaoCarta() {
		figuracaoValor = new FiguracaoValor();
		figuracaoNaipe = new FiguracaoNaipe();
	}

	public Carta asEspadas() {
		return new Carta(figuracaoValor.as(), figuracaoNaipe.espadas());
	}

	public Carta asCopas() {
		return new Carta(figuracaoValor.as(), figuracaoNaipe.copas());
	}

	public Carta asOuro() {
		return new Carta(figuracaoValor.as(), figuracaoNaipe.ouro());
	}

	public Carta reiEspadas() {
		return new Carta(figuracaoValor.rei(), figuracaoNaipe.espadas());
	}

	public Carta reiCopas() {
		return new Carta(figuracaoValor.rei(), figuracaoNaipe.copas());
	}

	public Carta reiOuro() {
		return new Carta(figuracaoValor.rei(), figuracaoNaipe.ouro());
	}

	public Carta asPaus() {
		return new Carta(figuracaoValor.as(), figuracaoNaipe.paus());
	}

	public Carta dezPaus() {
		return new Carta(figuracaoValor.dez(), figuracaoNaipe.paus());
	}

	public Carta oitoPaus() {
		return new Carta(figuracaoValor.oito(), figuracaoNaipe.paus());
	}

	public Carta seisPaus() {
		return new Carta(figuracaoValor.seis(), figuracaoNaipe.paus());
	}

	public Carta doisEspadas() {
		return new Carta(figuracaoValor.dois(), figuracaoNaipe.espadas());
	}

	public Carta doisCopas() {
		return new Carta(figuracaoValor.dois(), figuracaoNaipe.copas());
	}

}
