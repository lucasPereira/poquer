package br.iucas.poquer.testes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.AgrupadorDeCartas;
import br.iucas.poquer.AgrupadorDeCartasPorNaipe;
import br.iucas.poquer.Carta;
import br.iucas.poquer.figuracao.FiguracaoCarta;

public class TesteAgrupadorDeCartasPorNaipe {

	private Carta reiEspadas;
	private Carta damaEspadas;
	private Carta valeteEspadas;
	private Carta asCopas;
	private Carta reiCopas;

	@Before
	public void configurar() throws Exception {
		FiguracaoCarta figuracaoCarta = new FiguracaoCarta();
		reiEspadas = figuracaoCarta.reiEspadas();
		damaEspadas = figuracaoCarta.damaEspadas();
		valeteEspadas = figuracaoCarta.valeteEspadas();
		asCopas = figuracaoCarta.asCopas();
		reiCopas = figuracaoCarta.reiCopas();
	}

	@Test
	public void doisAgrupamentosDeDois() throws Exception {
		AgrupadorDeCartas agrupador = new AgrupadorDeCartasPorNaipe(Arrays.asList(damaEspadas, reiEspadas, reiCopas, asCopas));
		assertEquals(Arrays.asList(Arrays.asList(asCopas, reiCopas), Arrays.asList(reiEspadas, damaEspadas)), agrupador.agrupar(2));
	}

	@Test
	public void umAgrupamentoDeDoisUmAgrupamentoDeTres() throws Exception {
		AgrupadorDeCartas agrupador = new AgrupadorDeCartasPorNaipe(Arrays.asList(damaEspadas, reiEspadas, valeteEspadas, reiCopas, asCopas));
		assertEquals(Arrays.asList(Arrays.asList(asCopas, reiCopas), Arrays.asList(reiEspadas, damaEspadas, valeteEspadas)), agrupador.agrupar(2));
	}

	@Test
	public void umAgrupamentoDeTres() throws Exception {
		AgrupadorDeCartas agrupador = new AgrupadorDeCartasPorNaipe(Arrays.asList(damaEspadas, reiEspadas, valeteEspadas, reiCopas, asCopas));
		assertEquals(Arrays.asList(Arrays.asList(reiEspadas, damaEspadas, valeteEspadas)), agrupador.agrupar(3));
	}

}
