package br.iucas.poquer.testes;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Carta;
import br.iucas.poquer.VerificacaoDeJogo;
import br.iucas.poquer.VerificadorDeDoisPares;
import br.iucas.poquer.figuracao.FiguracaoCarta;

public class TesteVerificadorDeDoisPares {

	private VerificadorDeDoisPares verificador;
	private Carta asEspadas;
	private Carta asPaus;
	private Carta asCopas;
	private Carta reiEspadas;
	private Carta reiCopas;
	private Carta doisEspadas;
	private Carta doisCopas;

	@Before
	public void configurar() throws Exception {
		FiguracaoCarta figuracaoCarta = new FiguracaoCarta();
		asEspadas = figuracaoCarta.asEspadas();
		asCopas = figuracaoCarta.asCopas();
		asPaus = figuracaoCarta.asPaus();
		reiEspadas = figuracaoCarta.reiEspadas();
		reiCopas = figuracaoCarta.reiCopas();
		doisEspadas = figuracaoCarta.doisEspadas();
		doisCopas = figuracaoCarta.doisCopas();
		verificador = new VerificadorDeDoisPares();
	}

	@Test
	public void doisPares() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(doisCopas, asCopas, doisEspadas, asEspadas));
		assertEquals(Arrays.asList(asEspadas, asCopas, doisEspadas, doisCopas), verificacao.obterJogo());
		assertTrue(verificacao.valido());
	}

	@Test
	public void umPar() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(asCopas, doisEspadas, asEspadas));
		assertEquals(Arrays.asList(), verificacao.obterJogo());
		assertFalse(verificacao.valido());
	}

	@Test
	public void doisParesUmaTrinca() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(doisCopas, doisEspadas, asCopas, asPaus, asEspadas, reiCopas, reiEspadas));
		assertEquals(Arrays.asList(reiEspadas, reiCopas, doisEspadas, doisCopas, asEspadas), verificacao.obterJogo());
		assertTrue(verificacao.valido());
	}

}
