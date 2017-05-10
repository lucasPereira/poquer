package br.iucas.poquer.testes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Carta;
import br.iucas.poquer.figuracao.FiguracaoCarta;

public class TesteAgrupadorDeCartasPorValor {

	private Carta asEspadas;
	private Carta asCopas;
	private Carta asPaus;
	private Carta reiEspadas;
	private Carta reiCopas;

	@Before
	public void configurar() throws Exception {
		FiguracaoCarta figuracaoCarta = new FiguracaoCarta();
		asEspadas = figuracaoCarta.asEspadas();
		asCopas = figuracaoCarta.asCopas();
		asPaus = figuracaoCarta.asPaus();
		reiEspadas = figuracaoCarta.reiEspadas();
		reiCopas = figuracaoCarta.reiCopas();
	}

	@Test
	public void pares() throws Exception {
		List<Carta> cartas = Arrays.asList(asEspadas, asCopas);
		AgrupadorDeCartasPorValor agrupador = new AgrupadorDeCartasPorValor(cartas);
		assertEquals(Arrays.asList(Arrays.asList(asEspadas, asCopas)), agrupador.agrupar(2));
	}

	@Test
	public void doisPares() throws Exception {
		List<Carta> cartas = Arrays.asList(reiEspadas, reiCopas, asEspadas, asCopas);
		AgrupadorDeCartasPorValor agrupador = new AgrupadorDeCartasPorValor(cartas);
		assertEquals(Arrays.asList(Arrays.asList(asEspadas, asCopas), Arrays.asList(reiEspadas, reiCopas)), agrupador.agrupar(2));
	}

	@Test
	public void parTrinca() throws Exception {
		List<Carta> cartas = Arrays.asList(asPaus, reiEspadas, reiCopas, asEspadas, asCopas);
		AgrupadorDeCartasPorValor agrupador = new AgrupadorDeCartasPorValor(cartas);
		assertEquals(Arrays.asList(Arrays.asList(reiEspadas, reiCopas)), agrupador.agrupar(2));
		assertEquals(Arrays.asList(Arrays.asList(asEspadas, asPaus, asCopas)), agrupador.agrupar(3));
	}

}
