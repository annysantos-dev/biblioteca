package edu.uepb.web.biblioteca.enums;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 *
 *        Enums para os tipos do nivel da academica
 */
public enum TipoNivel {
	GRADUACAO("Graduação"),
	ESPECIALIZACAO("Especialização"),
	MESTRADO("Mestrado"),
	DOUTORADO("Doutourado");

	private String description;

	TipoNivel(String description) {this.description = description;}

	public String getTipoNivel() { return description; }

}
