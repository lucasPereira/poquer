package br.iucas.poquer.testes;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Carta;
import br.iucas.poquer.VerificacaoDeJogo;
import br.iucas.poquer.VerificadorDeJogo;
import br.iucas.poquer.VerificadorDeQuadra;
import br.iucas.poquer.figuracao.FiguracaoCarta;

public class TesteVerificadorDeQuadra {

	private Carta asEspadas;
	private Carta asPaus;
	private Carta asCopas;
	private Carta asOuro;
	private Carta reiEspadas;
	private Carta doisEspadas;
	private Carta doisCopas;

	@Before
	public void configurar() throws Exception {
		FiguracaoCarta figuracaoCarta = new FiguracaoCarta();
		asEspadas = figuracaoCarta.asEspadas();
		asPaus = figuracaoCarta.asPaus();
		asCopas = figuracaoCarta.asCopas();
		asOuro = figuracaoCarta.asOuro();
		reiEspadas = figuracaoCarta.reiEspadas();
		doisEspadas = figuracaoCarta.doisEspadas();
		doisCopas = figuracaoCarta.doisCopas();
	}

	@Test
	public void quadra() throws Exception {
		VerificadorDeJogo verificador = new VerificadorDeQuadra();
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(asCopas, asOuro, asEspadas, asPaus));
		assertEquals(Arrays.asList(asEspadas, asPaus, asCopas, asOuro), verificacao.obterJogo());
		assertTrue(verificacao.valido());
	}

	@Test
	public void trinca() throws Exception {
		VerificadorDeJogo verificador = new VerificadorDeQuadra();
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(asCopas, asOuro, asEspadas, reiEspadas));
		assertEquals(Arrays.asList(), verificacao.obterJogo());
		assertFalse(verificacao.valido());
	}

	@Test
	public void quadraParBaixoCartaAlta() throws Exception {
		VerificadorDeJogo verificador = new VerificadorDeQuadra();
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(asCopas, asOuro, asEspadas, asPaus, doisEspadas, doisCopas, reiEspadas));
		assertEquals(Arrays.asList(asEspadas, asPaus, asCopas, asOuro, reiEspadas), verificacao.obterJogo());
		assertTrue(verificacao.valido());
	}

}
