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

	public Carta asPaus() {
		return new Carta(figuracaoValor.as(), figuracaoNaipe.paus());
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

	public Carta damaEspadas() {
		return new Carta(figuracaoValor.dama(), figuracaoNaipe.espadas());
	}

	public Carta valeteEspadas() {
		return new Carta(figuracaoValor.valete(), figuracaoNaipe.espadas());
	}

	public Carta dezEspadas() {
		return new Carta(figuracaoValor.dez(), figuracaoNaipe.espadas());
	}

	public Carta dezPaus() {
		return new Carta(figuracaoValor.dez(), figuracaoNaipe.paus());
	}

	public Carta oitoEspadas() {
		return new Carta(figuracaoValor.oito(), figuracaoNaipe.espadas());
	}

	public Carta novePaus() {
		return new Carta(figuracaoValor.nove(), figuracaoNaipe.paus());
	}

	public Carta oitoPaus() {
		return new Carta(figuracaoValor.oito(), figuracaoNaipe.paus());
	}

	public Carta seisPaus() {
		return new Carta(figuracaoValor.seis(), figuracaoNaipe.paus());
	}

	public Carta cincoPaus() {
		return new Carta(figuracaoValor.cinco(), figuracaoNaipe.paus());
	}

	public Carta quatroPaus() {
		return new Carta(figuracaoValor.quatro(), figuracaoNaipe.paus());
	}

	public Carta tresPaus() {
		return new Carta(figuracaoValor.tres(), figuracaoNaipe.paus());
	}

	public Carta doisEspadas() {
		return new Carta(figuracaoValor.dois(), figuracaoNaipe.espadas());
	}

	public Carta doisCopas() {
		return new Carta(figuracaoValor.dois(), figuracaoNaipe.copas());
	}

}
