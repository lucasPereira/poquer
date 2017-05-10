package br.iucas.poquer.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Naipe;
import br.iucas.poquer.figuracao.FiguracaoNaipe;

public class TesteNaipe {

	private Naipe espadas;
	private Naipe paus;
	private Naipe copas;
	private Naipe ouro;

	@Before
	public void configurar() throws Exception {
		espadas = new FiguracaoNaipe().espadas();
		paus = new FiguracaoNaipe().paus();
		copas = new FiguracaoNaipe().copas();
		ouro = new FiguracaoNaipe().ouro();
	}

	@Test
	public void naipe() throws Exception {
		Naipe espadas = new Naipe('*');
		assertEquals("*", espadas.toString());
		assertEquals(espadas, new Naipe('*'));
	}

	@Test
	public void esparasMaiorQuePausCopasOuro() throws Exception {
		assertFalse(espadas.maiorQue(espadas));
		assertTrue(espadas.maiorQue(paus));
		assertTrue(espadas.maiorQue(copas));
		assertTrue(espadas.maiorQue(ouro));
	}

	@Test
	public void pausMaiorQueCopasOuro() throws Exception {
		assertFalse(paus.maiorQue(espadas));
		assertFalse(paus.maiorQue(paus));
		assertTrue(paus.maiorQue(copas));
		assertTrue(paus.maiorQue(ouro));
	}

	@Test
	public void copasMaiorQueOuro() throws Exception {
		assertFalse(copas.maiorQue(espadas));
		assertFalse(copas.maiorQue(paus));
		assertFalse(copas.maiorQue(copas));
		assertTrue(copas.maiorQue(ouro));
	}

	@Test
	public void ouroMenorQueEspadasPausCopas() throws Exception {
		assertFalse(ouro.maiorQue(espadas));
		assertFalse(ouro.maiorQue(paus));
		assertFalse(ouro.maiorQue(copas));
		assertFalse(ouro.maiorQue(ouro));
	}

}
