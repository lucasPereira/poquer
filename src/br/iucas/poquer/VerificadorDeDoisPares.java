package br.iucas.poquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VerificadorDeDoisPares implements VerificadorDeJogo {

	@Override
	public VerificacaoDeJogo verificar(List<Carta> cartas) {
		cartas = new ArrayList<>(cartas);
		VerificadorDePar verificadorDePar = new VerificadorDePar();
		VerificacaoDeJogo verificacaoPrimeiroPar = verificadorDePar.verificar(cartas);
		if (verificacaoPrimeiroPar.valido()) {
			List<Carta> jogo = new ArrayList<>(5);
			Iterator<Carta> par = verificacaoPrimeiroPar.obterJogo().iterator();
			Carta parItem1 = par.next();
			Carta parItem2 = par.next();
			jogo.add(parItem1);
			jogo.add(parItem2);
			cartas.remove(parItem1);
			cartas.remove(parItem2);
			VerificacaoDeJogo verificacaoSegundoPar = verificadorDePar.verificar(cartas);
			if (verificacaoSegundoPar.valido()) {
				Integer contador = 0;
				Iterator<Carta> desempate = verificacaoSegundoPar.obterJogo().iterator();
				while (contador < 3 && desempate.hasNext()) {
					jogo.add(desempate.next());
					contador++;
				}
				return new VerificacaoDeJogo(jogo);
			}
		}
		return new VerificacaoDeJogo(Arrays.asList());
	}

}
