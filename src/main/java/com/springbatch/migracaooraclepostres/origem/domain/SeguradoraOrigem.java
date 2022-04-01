package com.springbatch.migracaooraclepostres.origem.domain;

import lombok.Data;

@Data
public class SeguradoraOrigem {

    private Integer pkSeguradora;
    private String nmSeguradora;
    private String cidade;
    private String estado;
    private Integer pkMatriz;

}
