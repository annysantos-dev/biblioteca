package edu.uepb.web.biblioteca.model;

import lombok.Data;

/**
 * A classe POJO para Divida
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Data
public class Divida {
	private int id;
	private Aluno aluno;
	private Emprestimo emprestimo;
	private float saldo;
	private boolean pago;

}
