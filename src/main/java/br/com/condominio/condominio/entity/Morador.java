package br.com.condominio.condominio.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Morador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(name = "nome", nullable = false)
    protected String nome;

    @Column(name = "cpf", nullable = false)
    protected String cpf;

    @Column(name = "email", nullable = false)
    protected String email;


    @Column(name = "bloco", nullable = false)
    private  String bloco;

    @Column(name = "apartamento", nullable = false)
    private  int apartamento;

}
