package com.springbatch.migracaooraclepostres.destino.domain;

import lombok.Data;

@Data
public class Produto {

    private Integer id;
    private String descricao;
    private Double valor;
    private Integer seguradoraId;

}
