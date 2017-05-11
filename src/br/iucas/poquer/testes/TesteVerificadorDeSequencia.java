package br.iucas.poquer.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Carta;
import br.iucas.poquer.VerificacaoDeJogo;
import br.iucas.poquer.VerificadorDeSequencia;
import br.iucas.poquer.figuracao.FiguracaoCarta;

public class TesteVerificadorDeSequencia {

	private Carta asEspadas;
	private Carta reiEspadas;
	private Carta damaEspadas;
	private Carta valeteEspadas;
	private Carta dezPaus;
	private Carta novePaus;
	private Carta oitoPaus;
	private Carta seisPaus;
	private Carta cincoPaus;
	private Carta quatroPaus;
	private Carta tresPaus;
	private Carta doisCopas;
	private VerificadorDeSequencia verificador;

	@Before
	public void configurar() throws Exception {
		FiguracaoCarta figuracaoCarta = new FiguracaoCarta();
		asEspadas = figuracaoCarta.asEspadas();
		reiEspadas = figuracaoCarta.reiEspadas();
		damaEspadas = figuracaoCarta.damaEspadas();
		valeteEspadas = figuracaoCarta.valeteEspadas();
		dezPaus = figuracaoCarta.dezPaus();
		novePaus = figuracaoCarta.novePaus();
		oitoPaus = figuracaoCarta.oitoPaus();
		seisPaus = figuracaoCarta.seisPaus();
		cincoPaus = figuracaoCarta.cincoPaus();
		quatroPaus = figuracaoCarta.quatroPaus();
		tresPaus = figuracaoCarta.tresPaus();
		doisCopas = figuracaoCarta.doisCopas();
		verificador = new VerificadorDeSequencia();
	}

	@Test
	public void sequenciaAlta() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(valeteEspadas, damaEspadas, doisCopas, reiEspadas, dezPaus, asEspadas));
		assertEquals(Arrays.asList(asEspadas, reiEspadas, damaEspadas, valeteEspadas, dezPaus), verificacao.obterJogo());
		assertTrue(verificacao.valido());
	}

	@Test
	public void semSequencia() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(valeteEspadas, damaEspadas, doisCopas, reiEspadas, asEspadas));
		assertEquals(Arrays.asList(), verificacao.obterJogo());
		assertFalse(verificacao.valido());
	}

	@Test
	public void sequenciaAltaMenorSequenciaAltaMaiorFurada() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(valeteEspadas, novePaus, damaEspadas, oitoPaus, doisCopas, dezPaus, asEspadas));
		assertEquals(Arrays.asList(damaEspadas, valeteEspadas, dezPaus, novePaus, oitoPaus), verificacao.obterJogo());
		assertTrue(verificacao.valido());
	}

	@Test
	public void sequenciaBaixa() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(valeteEspadas, damaEspadas, cincoPaus, doisCopas, reiEspadas, tresPaus, quatroPaus, asEspadas));
		assertEquals(Arrays.asList(cincoPaus, quatroPaus, tresPaus, doisCopas, asEspadas), verificacao.obterJogo());
		assertTrue(verificacao.valido());
	}

	@Test
	public void sequenciaBaixaMaior() throws Exception {
		VerificacaoDeJogo verificacao = verificador.verificar(Arrays.asList(valeteEspadas, seisPaus, damaEspadas, cincoPaus, doisCopas, reiEspadas, tresPaus, quatroPaus, asEspadas));
		assertEquals(Arrays.asList(seisPaus, cincoPaus, quatroPaus, tresPaus, doisCopas), verificacao.obterJogo());
		assertTrue(verificacao.valido());
	}

}
