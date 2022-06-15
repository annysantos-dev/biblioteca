package edu.uepb.web.biblioteca.model;

import edu.uepb.web.biblioteca.enums.TipoNivel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A classe POJO do Curso
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 *
 */
@Data
@NoArgsConstructor
public class Curso {
	private int id;
	private String nome;
	private String area;
	private TipoNivel nivel;

	public Curso(String nome, TipoNivel nivel, String area) {
		this.nome = nome;
		this.area = area;
		this.nivel = nivel;
	}
	public void setTipoNivel(String nivel) {
		this.nivel = TipoNivel.valueOf(nivel);
	}
}
