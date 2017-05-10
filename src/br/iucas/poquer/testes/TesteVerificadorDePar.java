package br.iucas.poquer.testes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Carta;
import br.iucas.poquer.VerificacaoDeJogo;
import br.iucas.poquer.VerificadorDeJogo;
import br.iucas.poquer.VerificadorDePar;
import br.iucas.poquer.figuracao.FiguracaoCarta;

public class TesteVerificadorDePar {

	private VerificadorDeJogo verificadorDePar;
	private Carta asEspadas;
	private Carta asCopas;
	private Carta asPaus;
	private Carta reiEspadas;
	private Carta reiCopas;
	private Carta dezPaus;
	private Carta oitoPaus;
	private Carta seisPaus;
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
		dezPaus = figuracaoCarta.dezPaus();
		oitoPaus = figuracaoCarta.oitoPaus();
		seisPaus = figuracaoCarta.seisPaus();
		doisEspadas = figuracaoCarta.doisEspadas();
		doisCopas = figuracaoCarta.doisCopas();
		verificadorDePar = new VerificadorDePar();
	}

	@Test
	public void duasCartasDeMesmoValor() throws Exception {
		List<Carta> cartas = Arrays.asList(asEspadas, asCopas);
		VerificacaoDeJogo verificacao = verificadorDePar.verificar(cartas);
		List<Carta> jogo = Arrays.asList(asEspadas, asCopas);
		assertTrue(verificacao.valido());
		assertEquals(jogo, verificacao.obterJogo());
	}

	@Test
	public void duasCartasComValoresDiferentes() throws Exception {
		List<Carta> cartas = Arrays.asList(asEspadas, reiEspadas);
		VerificacaoDeJogo verificacao = verificadorDePar.verificar(cartas);
		List<Carta> jogo = Arrays.asList();
		assertFalse(verificacao.valido());
		assertEquals(jogo, verificacao.obterJogo());
	}

	@Test
	public void doisPares() throws Exception {
		List<Carta> cartas = Arrays.asList(reiEspadas, reiCopas, asEspadas, asCopas);
		VerificacaoDeJogo verificacao = verificadorDePar.verificar(cartas);
		List<Carta> jogo = Arrays.asList(asEspadas, asCopas, reiEspadas, reiCopas);
		assertTrue(verificacao.valido());
		assertEquals(jogo, verificacao.obterJogo());
	}

	@Test
	public void parComTresCartasNaoOrdenadas() throws Exception {
		List<Carta> cartas = Arrays.asList(dezPaus, reiEspadas, oitoPaus, reiCopas, asPaus);
		VerificacaoDeJogo verificacao = verificadorDePar.verificar(cartas);
		List<Carta> jogo = Arrays.asList(reiEspadas, reiCopas, asPaus, dezPaus, oitoPaus);
		assertTrue(verificacao.valido());
		assertEquals(jogo, verificacao.obterJogo());
	}

	@Test
	public void seteCartasParAltoParBaixo() throws Exception {
		List<Carta> cartas = Arrays.asList(oitoPaus, asEspadas, doisEspadas, seisPaus, asCopas, doisCopas, dezPaus);
		VerificacaoDeJogo verificacao = verificadorDePar.verificar(cartas);
		List<Carta> jogo = Arrays.asList(asEspadas, asCopas, dezPaus, oitoPaus, seisPaus);
		assertTrue(verificacao.valido());
		assertEquals(jogo, verificacao.obterJogo());
	}

}
