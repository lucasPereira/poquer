package br.iucas.poquer;

public class Valor {

	private String simbolo;
	private Integer ordemInferior;
	private Integer ordemSuperior;

	public Valor(String simbolo, Integer ordemInferior, Integer ordemSuperior) {
		this.simbolo = simbolo;
		this.ordemInferior = ordemInferior;
		this.ordemSuperior = ordemSuperior;
	}

	public Boolean superiorMaiorQue(Valor valor) {
		return ordemSuperior > valor.ordemSuperior;
	}

	public Boolean inferiorMenorQue(Valor valor) {
		return ordemInferior < valor.ordemInferior;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Valor) {
			Valor valor = (Valor) objeto;
			return simbolo.equals(valor.simbolo) && ordemInferior.equals(valor.ordemInferior) && ordemSuperior.equals(valor.ordemSuperior);
		}
		return super.equals(objeto);
	}

	@Override
	public int hashCode() {
		return simbolo.hashCode();
	}

	@Override
	public String toString() {
		return simbolo;
	}

}
