package com.springbatch.migracaooraclepostres.destino.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Seguradora {

    private Integer id;
    private String nomeFantasia;
    private String cidade;
    private String estado;
    private List<Corretor> corretores = new ArrayList<>();

    public void addCorretor(Corretor corretor) {
        corretores.add(corretor);
    }

}
