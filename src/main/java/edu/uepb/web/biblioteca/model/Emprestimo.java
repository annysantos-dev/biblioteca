package edu.uepb.web.biblioteca.model;

import lombok.Data;

/**
 * A classe POJO do Emprestimo
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Data
public class Emprestimo {
	private int id;
	private Funcionario funcionario;
	private Aluno aluno;
	private Item item;
	private String dataCadastrado;
	private String dataDevolucao;
	private int renovacao;
	private boolean entregou;

}
