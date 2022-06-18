package edu.uepb.web.biblioteca.enums;


/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 *
 *
 */
public enum TipoItem {
	ANAIS("anais"),
	JORNAL("jornal"),
	LIVRO("livro"),
	MIDIA("mídia"),
	REVISTA("revista"),
	TRABALHOCONCLUSAO("trabalho conclusão");

	private String description;

	TipoItem(String description) {this.description = description;}

	public String getTipoItem() { return description; }
}

