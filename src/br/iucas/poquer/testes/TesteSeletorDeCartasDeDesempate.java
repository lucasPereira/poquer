package br.iucas.poquer.testes;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Carta;
import br.iucas.poquer.SeletorDeCartasDeDesempate;
import br.iucas.poquer.figuracao.FiguracaoCarta;

public class TesteSeletorDeCartasDeDesempate {

	private Carta asEspadas;
	private Carta reiEspadas;

	@Before
	public void configurar() throws Exception {
		FiguracaoCarta figuracaoCarta = new FiguracaoCarta();
		asEspadas = figuracaoCarta.asEspadas();
		reiEspadas = figuracaoCarta.reiEspadas();
	}

	@Test
	public void selecionarUmaCartaDeUma() throws Exception {
		SeletorDeCartasDeDesempate seletor = new SeletorDeCartasDeDesempate();
		assertEquals(Arrays.asList(asEspadas), seletor.selecionar(1, Arrays.asList(asEspadas)));
	}

	@Test
	public void selecionarUmaCartaDeDuas() throws Exception {
		SeletorDeCartasDeDesempate seletor = new SeletorDeCartasDeDesempate();
		assertEquals(Arrays.asList(asEspadas), seletor.selecionar(1, Arrays.asList(reiEspadas, asEspadas)));
	}

	@Test
	public void selecionarDuasCartaDeUma() throws Exception {
		SeletorDeCartasDeDesempate seletor = new SeletorDeCartasDeDesempate();
		assertEquals(Arrays.asList(reiEspadas), seletor.selecionar(2, Arrays.asList(reiEspadas)));
	}

}
