package edu.uepb.web.biblioteca.model;

import edu.uepb.web.biblioteca.enums.TipoFuncionario;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A classe POJO do Funcionario
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class Funcionario extends Usuario{
	private int id;
	private TipoFuncionario tipoFunc;
	private String usuario;

	public void setTipoFuncio(String tipoFunc) {
		this.tipoFunc = TipoFuncionario.valueOf(tipoFunc);
	}

	public Funcionario(String nome, TipoFuncionario tipoFunc, String cpf, String rg, String naturalidade,
					   String endereco, String telefone, String email, String usuario, String senha) {
		super(nome, cpf, rg, naturalidade, endereco, telefone, email, senha);
		this.tipoFunc = tipoFunc;
		this.usuario = usuario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
