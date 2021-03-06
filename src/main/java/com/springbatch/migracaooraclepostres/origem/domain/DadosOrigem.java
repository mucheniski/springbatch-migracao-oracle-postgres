package com.springbatch.migracaooraclepostres.origem.domain;

import lombok.Data;

@Data
public class DadosOrigem {

    private Integer pkCorretor;

    private String nmCorretor;

    private String cpfCorretor;

    private String dscProduto;

    private Double vlrProduto;

    private Integer pkSeguradora;

    private String nmSeguradora;

    private String cidade;

    private String estado;

    private Integer pkMatriz;

    private String razaoSocial;

}
