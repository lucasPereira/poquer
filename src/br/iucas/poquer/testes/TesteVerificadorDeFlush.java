package br.iucas.poquer.testes;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Carta;
import br.iucas.poquer.VerificacaoDeJogo;
import br.iucas.poquer.VerificadorDeFlush;
import br.iucas.poquer.figuracao.FiguracaoCarta;

public class TesteVerificadorDeFlush {

	private VerificadorDeFlush verificador;
	private Carta asEspadas;
	private Carta reiEspadas;
	private Carta damaEspadas;
	private Carta valeteEspadas;
	private Carta oitoEspadas;
	private Carta doisEspadas;
	private Carta doisCopas;

	@Before
	public void configurar() throws Exception {
		FiguracaoCarta figuracaoCarta = new FiguracaoCarta();
		asEspadas = figuracaoCarta.asEspadas();
		reiEspadas = figuracaoCarta.reiEspadas();
		damaEspadas = figuracaoCarta.damaEspadas();
		valeteEspadas = figuracaoCarta.valeteEspadas();
		oitoEspadas = figuracaoCarta.oitoEspadas();
		doisEspadas = figuracaoCarta.doisEspadas();
		doisCopas = figuracaoCarta.doisCopas();
		verificador = new VerificadorDeFlush();
	}

	@Test
	public void flush() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(doisEspadas, valeteEspadas, damaEspadas, reiEspadas, asEspadas));
		assertEquals(Arrays.asList(asEspadas, reiEspadas, damaEspadas, valeteEspadas, doisEspadas), verificacao.obterJogo());
		assertTrue(verificacao.valido());
	}

	@Test
	public void semFlush() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(doisCopas, valeteEspadas, damaEspadas, reiEspadas, asEspadas));
		assertEquals(Arrays.asList(), verificacao.obterJogo());
		assertFalse(verificacao.valido());
	}
	
	@Test
	public void flushAltoBaixo() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(oitoEspadas, doisEspadas, valeteEspadas, damaEspadas, reiEspadas, asEspadas));
		assertEquals(Arrays.asList(asEspadas, reiEspadas, damaEspadas, valeteEspadas, oitoEspadas), verificacao.obterJogo());
		assertTrue(verificacao.valido());
	}

}
