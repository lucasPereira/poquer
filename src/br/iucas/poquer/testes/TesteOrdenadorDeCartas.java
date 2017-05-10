package br.iucas.poquer.testes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Carta;
import br.iucas.poquer.OrdenadorDeCartaAlta;
import br.iucas.poquer.OrdenadorDeListaPorCartaAlta;
import br.iucas.poquer.figuracao.FiguracaoCarta;

public class TesteOrdenadorDeCartas {

	private Carta asEspadas;
	private Carta asCopas;
	private Carta reiEspadas;
	private Carta doisEspadas;
	private OrdenadorDeCartaAlta ordenadorDeCartaAlta;
	private OrdenadorDeListaPorCartaAlta ordenadorDeListaPorCartaAlta;

	@Before
	public void configurar() throws Exception {
		FiguracaoCarta figuracao = new FiguracaoCarta();
		asEspadas = figuracao.asEspadas();
		asCopas = figuracao.asCopas();
		reiEspadas = figuracao.reiEspadas();
		doisEspadas = figuracao.doisEspadas();
		ordenadorDeCartaAlta = new OrdenadorDeCartaAlta();
		ordenadorDeListaPorCartaAlta = new OrdenadorDeListaPorCartaAlta();
	}

	@Test
	public void ordemSupeiorDecrescente() throws Exception {
		List<Carta> cartas = Arrays.asList(reiEspadas, doisEspadas, asEspadas);
		Collections.sort(cartas, ordenadorDeCartaAlta);
		assertEquals(Arrays.asList(asEspadas, reiEspadas, doisEspadas), cartas);
	}

	@Test
	public void ordemSupeiorDecrescenteDeValoresIguais() throws Exception {
		List<Carta> cartasEspadasAntesDeCopas = Arrays.asList(reiEspadas, doisEspadas, asEspadas, asCopas);
		List<Carta> cartasCopasAntesDeEspadas = Arrays.asList(reiEspadas, doisEspadas, asCopas, asEspadas);
		List<Carta> ordenacaoEsperada = Arrays.asList(asEspadas, asCopas, reiEspadas, doisEspadas);
		ordenadorDeCartaAlta.ordenar(cartasEspadasAntesDeCopas);
		ordenadorDeCartaAlta.ordenar(cartasCopasAntesDeEspadas);
		assertEquals(ordenacaoEsperada, cartasEspadasAntesDeCopas);
		assertEquals(ordenacaoEsperada, cartasCopasAntesDeEspadas);
	}

	@Test
	public void ordemDeListasSuperiorDecrescente() throws Exception {
		List<List<Carta>> sequenciasA = Arrays.asList(Arrays.asList(doisEspadas, reiEspadas), Arrays.asList(reiEspadas, doisEspadas, asEspadas));
		List<List<Carta>> sequenciasB = Arrays.asList(Arrays.asList(reiEspadas, doisEspadas, asEspadas), Arrays.asList(doisEspadas, reiEspadas));
		List<List<Carta>> sequenciasOrdenadas = Arrays.asList(Arrays.asList(asEspadas, reiEspadas, doisEspadas), Arrays.asList(reiEspadas, doisEspadas));
		ordenadorDeListaPorCartaAlta.ordenar(sequenciasA);
		ordenadorDeListaPorCartaAlta.ordenar(sequenciasB);
		assertEquals(sequenciasOrdenadas, sequenciasA);
		assertEquals(sequenciasOrdenadas, sequenciasB);
	}

	@Test
	public void ordemDeListasSuperiorDecrescenteComListaVazia() throws Exception {
		List<List<Carta>> sequenciasA = Arrays.asList(Arrays.asList(doisEspadas, reiEspadas), Arrays.asList());
		List<List<Carta>> sequenciasB = Arrays.asList(Arrays.asList(), Arrays.asList(doisEspadas, reiEspadas));
		List<List<Carta>> sequenciasOrdenadas = Arrays.asList(Arrays.asList(reiEspadas, doisEspadas), Arrays.asList());
		ordenadorDeListaPorCartaAlta.ordenar(sequenciasA);
		ordenadorDeListaPorCartaAlta.ordenar(sequenciasB);
		assertEquals(sequenciasOrdenadas, sequenciasA);
		assertEquals(sequenciasOrdenadas, sequenciasB);
	}

}
