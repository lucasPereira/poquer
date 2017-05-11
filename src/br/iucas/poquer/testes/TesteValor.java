package br.iucas.poquer.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Valor;
import br.iucas.poquer.figuracao.FiguracaoValor;

public class TesteValor {

	private Valor as;
	private Valor rei;
	private Valor dama;
	private Valor dois;

	@Before
	public void configurar() throws Exception {
		FiguracaoValor figuracaoValor = new FiguracaoValor();
		as = figuracaoValor.as();
		rei = figuracaoValor.rei();
		dama = figuracaoValor.dama();
		dois = figuracaoValor.dois();
	}

	@Test
	public void valor() throws Exception {
		Valor valor = new Valor("X", 1, 10);
		assertEquals("X", valor.toString());
		assertEquals("X".hashCode(), valor.hashCode());
		assertEquals(valor, new Valor("X", 1, 10));
		assertNotEquals(valor, new Valor("X", 2, 10));
		assertNotEquals(valor, new Valor("X", 1, 9));
	}

	@Test
	public void superiorMaior() throws Exception {
		assertTrue(as.superiorMaiorQue(rei));
		assertFalse(rei.superiorMaiorQue(as));
		assertFalse(as.superiorMaiorQue(as));
		assertFalse(rei.superiorMaiorQue(rei));
	}

	@Test
	public void inferiorMaior() throws Exception {
		assertFalse(as.inferiorMaiorQue(rei));
		assertTrue(rei.inferiorMaiorQue(as));
		assertFalse(as.inferiorMaiorQue(as));
		assertFalse(rei.inferiorMaiorQue(rei));
	}

	@Test
	public void sucessor() throws Exception {
		assertFalse(as.sucessor(as));
		assertTrue(as.sucessor(rei));
		assertFalse(as.sucessor(dama));
		assertFalse(as.sucessor(dois));
		assertFalse(rei.sucessor(as));
		assertFalse(rei.sucessor(rei));
		assertTrue(rei.sucessor(dama));
		assertFalse(rei.sucessor(dois));
		assertFalse(dama.sucessor(as));
		assertFalse(dama.sucessor(rei));
		assertFalse(dama.sucessor(dama));
		assertFalse(dama.sucessor(dois));
		assertTrue(dois.sucessor(as));
		assertFalse(dois.sucessor(rei));
		assertFalse(dois.sucessor(dama));
		assertFalse(dois.sucessor(dois));
	}

}
