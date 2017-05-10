package br.iucas.poquer.testes;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Carta;
import br.iucas.poquer.VerificacaoDeJogo;
import br.iucas.poquer.VerificadorDeTrinca;
import br.iucas.poquer.figuracao.FiguracaoCarta;

public class TesteVerificadorDeTrinca {

	private VerificadorDeTrinca verificador;
	private Carta asEspadas;
	private Carta asPaus;
	private Carta asCopas;

	@Before
	public void configurar() throws Exception {
		FiguracaoCarta figuracaoCarta = new FiguracaoCarta();
		asEspadas = figuracaoCarta.asEspadas();
		asPaus = figuracaoCarta.asPaus();
		asCopas = figuracaoCarta.asCopas();
		verificador = new VerificadorDeTrinca();
	}

	@Test
	public void trinca() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(asEspadas, asPaus, asCopas));
		assertEquals(Arrays.asList(asEspadas, asPaus, asCopas), verificacao.obterJogo());
		assertTrue(verificacao.valido());
	}

	@Test
	public void oar() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(asPaus, asCopas));
		assertEquals(Arrays.asList(), verificacao.obterJogo());
		assertFalse(verificacao.valido());
	}

}
