package edu.uepb.web.biblioteca.enums;

/**
 *        Enums para os tipos de anais do congresso
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 *
 */
public enum TipoAnais {
	ARTIGO("artigo"),
	POSTER("poster"),
	RESUMO("resumo"),
	NONE("none");

	private String description;

	TipoAnais(String description) {this.description = description;}

	public String getTipoAnais() { return description; }
}
