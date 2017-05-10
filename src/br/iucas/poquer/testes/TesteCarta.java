package br.iucas.poquer.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.iucas.poquer.Carta;
import br.iucas.poquer.Naipe;
import br.iucas.poquer.Valor;

public class TesteCarta {

	@Test
	public void carta() throws Exception {
		Valor valor = new Valor("X", 1, 10);
		Naipe naipe = new Naipe('*');
		Carta carta = new Carta(valor, naipe);
		assertEquals("X*", carta.toString());
		assertEquals(valor, carta.obterValor());
		assertEquals(naipe, carta.obterNaipe());
		assertEquals(carta, new Carta(new Valor("X", 1, 10), new Naipe('*')));
	}

}
