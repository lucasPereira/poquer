package br.iucas.poquer.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.iucas.poquer.Valor;
import br.iucas.poquer.figuracao.FiguracaoValor;

public class TesteValor {

	private Valor as;
	private Valor rei;

	@Before
	public void configurar() throws Exception {
		FiguracaoValor figuracaoValor = new FiguracaoValor();
		as = figuracaoValor.as();
		rei = figuracaoValor.rei();
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
	public void inferiorMenor() throws Exception {
		assertTrue(as.inferiorMenorQue(rei));
		assertFalse(rei.inferiorMenorQue(as));
		assertFalse(as.inferiorMenorQue(as));
		assertFalse(rei.inferiorMenorQue(rei));
	}

}
