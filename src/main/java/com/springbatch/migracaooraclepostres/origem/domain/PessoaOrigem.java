package com.springbatch.migracaooraclepostres.origem.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PESSOA_ORIGEM")
@NamedQuery(
        name = "buscarPessoas",
        query = "SELECT p FROM PessoaOrigem p"
)
public class PessoaOrigem {

    @Id
    @Column(name = "PK_PESSOA")
    private Integer pkPessoa;

    @Column(name = "NM_PESSOA")
    private String nmPessoa;

}
