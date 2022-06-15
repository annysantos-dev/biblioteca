package edu.uepb.web.biblioteca.model;

import edu.uepb.web.biblioteca.enums.TipoAnais;
import edu.uepb.web.biblioteca.enums.TipoItem;
import edu.uepb.web.biblioteca.enums.TipoMidia;
import edu.uepb.web.biblioteca.enums.TipoTrabalhoConclusao;
import lombok.Data;

/**
 * A classe POJO do Item
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Data
public class Item {
	private int id;
	private TipoItem tipoItem;
	private String isbn;
	private String titulo;
	TipoAnais tipoAnais;
	TipoMidia tipoMidia;
	TipoTrabalhoConclusao tipoTrabalho;
	private String autor;
	private String congresso;
	private String anoPublicacao;
	private String local;
	private String editora;
	private String edicao;
	private int numeroPagina;
	private String area;
	private String tema;
	private String dataGravacao;
	private String orientador;
	private String data;
	private int quantidade;
	public Item() {
		this.tipoAnais = TipoAnais.NONE;
		this.tipoMidia = TipoMidia.NONE;
		this.tipoTrabalho = TipoTrabalhoConclusao.NONE;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = TipoItem.valueOf(tipoItem);
	}

	public void setTipoAnais(String tipoAnais) {
		this.tipoAnais = TipoAnais.valueOf(tipoAnais);
	}

	public void setTipoMidia(String tipoMidia) {
		this.tipoMidia = TipoMidia.valueOf(tipoMidia);
	}

	public void setTipoTrabalho(String tipoTrabalho) {
		this.tipoTrabalho = TipoTrabalhoConclusao.valueOf(tipoTrabalho);
	}
}
