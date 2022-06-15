package edu.uepb.web.biblioteca.model;

import lombok.Data;

/**
 * A classe POJO da Reserva
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Data
public class Reserva {
	private int id;
	private Aluno aluno;
	private Item item;
	private String dataReservado;
	private String dataPegar;
	private boolean email;

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", aluno=" + aluno + ", item=" + item + ", dataReservado=" + dataReservado
				+ ", dataPegar=" + dataPegar + ", email=" + email + "]";
	}

}
