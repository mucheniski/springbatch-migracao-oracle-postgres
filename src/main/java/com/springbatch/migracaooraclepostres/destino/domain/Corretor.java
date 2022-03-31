package com.springbatch.migracaooraclepostres.destino.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Corretor {

    private Integer id;
    private String nome;
    private String cpf;
    private List<Seguradora> seguradoras = new ArrayList<>();

}
