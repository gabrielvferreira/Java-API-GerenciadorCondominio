package br.com.condominio.condominio.entity;

import javax.persistence.Column;
import java.io.Serializable;


public abstract class Pessoa implements Serializable {

    @Column(name = "nome", nullable = false)
    protected String nome;

    @Column(name = "cpf", nullable = false)
    protected String cpf;

    @Column(name = "email", nullable = false)
    protected String email;
}
