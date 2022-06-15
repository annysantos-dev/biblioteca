package edu.uepb.web.biblioteca.model;

import lombok.Data;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Data
public class Universidade {
	private int id;
	private String nome;
	private String endereco;
	private String periodo;
	private String inicioPeriodo;
	private String fimPeriodo;

	@Override
	public String toString() {
		return "Universidade [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", periodo=" + periodo
				+ ", inicioPeriodo=" + inicioPeriodo + ", fimPeriodo=" + fimPeriodo + "]";
	}

}
