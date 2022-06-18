package edu.uepb.web.biblioteca.enums;

/**
 * 
 * @author geovanniovinhas
 * 
 *         Enums para os tipos de midia
 *
 */
public enum TipoMidia {
	CD("cd"), DVD("dvd"), NONE("none");

	private String description;

	TipoMidia(String description) {this.description = description;}

	public String getTipoMidia() { return description; }
}
