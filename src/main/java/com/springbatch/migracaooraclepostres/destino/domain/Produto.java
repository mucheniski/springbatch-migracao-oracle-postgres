package com.springbatch.migracaooraclepostres.destino.domain;

import lombok.Data;

@Data
public class Produto {

    private String descricao;
    private Double valor;
    private Integer seguradoraLegadoId;
    private Integer idLegado;

}
