package edu.uepb.web.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private String nome;
    private String cpf;
    private String rg;
    private String naturalidade;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;
}
