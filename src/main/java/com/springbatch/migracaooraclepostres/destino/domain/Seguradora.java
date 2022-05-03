package com.springbatch.migracaooraclepostres.destino.domain;

import lombok.Data;

@Data
public class Seguradora {

    private String nomeFantasia;
    private String cidade;
    private String estado;
    private Integer matrizId;
    private Integer idLegado;

}
