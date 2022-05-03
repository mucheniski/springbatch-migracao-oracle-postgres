package com.springbatch.migracaooraclepostres.destino.domain;

import lombok.Data;

@Data
public class Corretor {

    private String nome;
    private String cpf;
    private Integer pkSeguradora;
    private Integer idLegado;

}
