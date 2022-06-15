package edu.uepb.web.biblioteca.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A classe POJO do Aluno
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
public class Aluno extends Usuario{

	private int id;
	private String matricula;
	private String nomeMae;
	private Curso curso;
	private String ano;
	private String periodoIngresso;

	public Aluno(String matricula, String rg, String cpf, String nome, String nomeMae, String naturalidade,
			String endereco, String telefone, Curso curso, String ano, String periodoIngresso, String email,
			String senha) {
		super(nome, cpf, rg, naturalidade, endereco, telefone, email, senha);
		this.matricula = matricula;
		this.nomeMae = nomeMae;
		this.curso = curso;
		this.ano = ano;
		this.periodoIngresso = periodoIngresso;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
