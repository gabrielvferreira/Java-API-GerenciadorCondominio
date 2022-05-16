package br.com.condominio.condominio.entity;

import br.com.condominio.condominio.enums.AreasDeServicoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Agenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(name = "locatario", nullable = false)
    private String locatario;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "areaDeServico", nullable = false)
    private AreasDeServicoEnum areaDeServico;

    @Column(name = "quantidadeDePessoas")
    private int quantidadeDePessoas;

    @Column(name = "guardaVidas")
    private boolean guardaVidas;

    @Column(name = "equipamentos")
    private boolean equipamentos;
}
