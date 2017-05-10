package br.iucas.poquer.testes;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Carta;
import br.iucas.poquer.VerificacaoDeJogo;
import br.iucas.poquer.VerificadorDeFullHouse;
import br.iucas.poquer.figuracao.FiguracaoCarta;

public class TesteVerificadorDeFullHouse {

	private VerificadorDeFullHouse verificador;
	private Carta asEspadas;
	private Carta asPaus;
	private Carta asCopas;
	private Carta reiEspadas;
	private Carta reiCopas;
	private Carta reiOuro;
	private Carta doisEspadas;
	private Carta doisCopas;

	@Before
	public void configurar() throws Exception {
		FiguracaoCarta figuracaoCarta = new FiguracaoCarta();
		asEspadas = figuracaoCarta.asEspadas();
		asPaus = figuracaoCarta.asPaus();
		asCopas = figuracaoCarta.asCopas();
		reiEspadas = figuracaoCarta.reiEspadas();
		reiCopas = figuracaoCarta.reiEspadas();
		reiOuro = figuracaoCarta.reiOuro();
		doisEspadas = figuracaoCarta.doisEspadas();
		doisCopas = figuracaoCarta.doisCopas();
		verificador = new VerificadorDeFullHouse();
	}

	@Test
	public void fullHouse() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(asEspadas, reiEspadas, asPaus, reiCopas, asCopas));
		assertEquals(Arrays.asList(asEspadas, asPaus, asCopas, reiEspadas, reiCopas), verificacao.obterJogo());
		assertTrue(verificacao.valido());
	}

	@Test
	public void doisPares() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(asEspadas, reiEspadas, asPaus, reiCopas));
		assertEquals(Arrays.asList(), verificacao.obterJogo());
		assertFalse(verificacao.valido());
	}

	@Test
	public void trincaDoisPares() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(asEspadas, reiEspadas, doisEspadas, asPaus, reiCopas, reiOuro, doisCopas));
		assertEquals(Arrays.asList(reiEspadas, reiCopas, reiOuro, asEspadas, asPaus), verificacao.obterJogo());
		assertTrue(verificacao.valido());
	}

}
