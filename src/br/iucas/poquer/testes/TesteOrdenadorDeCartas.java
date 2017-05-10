package br.iucas.poquer.testes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Carta;
import br.iucas.poquer.OrdenadorDeListaSuperiorDecrescente;
import br.iucas.poquer.OrdenadorSuperiorDecrescente;
import br.iucas.poquer.figuracao.FiguracaoCarta;

public class TesteOrdenadorDeCartas {

	private Carta asEspadas;
	private Carta asCopas;
	private Carta reiEspadas;
	private Carta doisEspadas;
	private OrdenadorSuperiorDecrescente ordenadorSuperiorDecrescente;
	private OrdenadorDeListaSuperiorDecrescente ordenadorDeListaSuperiorDecrescente;

	@Before
	public void configurar() throws Exception {
		FiguracaoCarta figuracao = new FiguracaoCarta();
		asEspadas = figuracao.asEspadas();
		asCopas = figuracao.asCopas();
		reiEspadas = figuracao.reiEspadas();
		doisEspadas = figuracao.doisEspadas();
		ordenadorSuperiorDecrescente = new OrdenadorSuperiorDecrescente();
		ordenadorDeListaSuperiorDecrescente = new OrdenadorDeListaSuperiorDecrescente();
	}

	@Test
	public void ordemSupeiorDecrescente() throws Exception {
		List<Carta> cartas = Arrays.asList(reiEspadas, doisEspadas, asEspadas);
		Collections.sort(cartas, ordenadorSuperiorDecrescente);
		assertEquals(Arrays.asList(asEspadas, reiEspadas, doisEspadas), cartas);
	}

	@Test
	public void ordemSupeiorDecrescenteDeValoresIguais() throws Exception {
		List<Carta> cartasEspadasAntesDeCopas = Arrays.asList(reiEspadas, doisEspadas, asEspadas, asCopas);
		List<Carta> cartasCopasAntesDeEspadas = Arrays.asList(reiEspadas, doisEspadas, asCopas, asEspadas);
		List<Carta> ordenacaoEsperada = Arrays.asList(asEspadas, asCopas, reiEspadas, doisEspadas);
		ordenadorSuperiorDecrescente.ordenar(cartasEspadasAntesDeCopas);
		ordenadorSuperiorDecrescente.ordenar(cartasCopasAntesDeEspadas);
		assertEquals(ordenacaoEsperada, cartasEspadasAntesDeCopas);
		assertEquals(ordenacaoEsperada, cartasCopasAntesDeEspadas);
	}

	@Test
	public void ordemDeListasSuperiorDecrescente() throws Exception {
		List<List<Carta>> sequenciasA = Arrays.asList(Arrays.asList(doisEspadas, reiEspadas), Arrays.asList(reiEspadas, doisEspadas, asEspadas));
		List<List<Carta>> sequenciasB = Arrays.asList(Arrays.asList(reiEspadas, doisEspadas, asEspadas), Arrays.asList(doisEspadas, reiEspadas));
		List<List<Carta>> sequenciasOrdenadas = Arrays.asList(Arrays.asList(asEspadas, reiEspadas, doisEspadas), Arrays.asList(reiEspadas, doisEspadas));
		ordenadorDeListaSuperiorDecrescente.ordenar(sequenciasA);
		ordenadorDeListaSuperiorDecrescente.ordenar(sequenciasB);
		assertEquals(sequenciasOrdenadas, sequenciasA);
		assertEquals(sequenciasOrdenadas, sequenciasB);
	}

	@Test
	public void ordemDeListasSuperiorDecrescenteComListaVazia() throws Exception {
		List<List<Carta>> sequenciasA = Arrays.asList(Arrays.asList(doisEspadas, reiEspadas), Arrays.asList());
		List<List<Carta>> sequenciasB = Arrays.asList(Arrays.asList(), Arrays.asList(doisEspadas, reiEspadas));
		List<List<Carta>> sequenciasOrdenadas = Arrays.asList(Arrays.asList(reiEspadas, doisEspadas), Arrays.asList());
		ordenadorDeListaSuperiorDecrescente.ordenar(sequenciasA);
		ordenadorDeListaSuperiorDecrescente.ordenar(sequenciasB);
		assertEquals(sequenciasOrdenadas, sequenciasA);
		assertEquals(sequenciasOrdenadas, sequenciasB);
	}

}
