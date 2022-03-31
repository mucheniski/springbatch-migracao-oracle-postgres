package com.springbatch.migracaooraclepostres.origem.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table()
@NamedQuery(
        name = "buscarDados",
        query = "SELECT d FROM DadosOrigem d"
)
public class DadosOrigem {

    @Id
    @Column(name = "PK_CORRETOR")
    private Integer pkCorretor;

    @Column(name = "NM_CORRETOR")
    private String nmCorretor;

    @Column(name = "CPF_CORRETOR")
    private String cpfCorretor;

    @Column(name = "DSC_PRODUTO")
    private String dscProduto;

    @Column(name = "VLR_PRODUTO")
    private Double vlrProduto;

    @Column(name = "PK_SEGURADORA")
    private Integer pkSeguradora;

    @Column(name = "NM_SEGURADORA")
    private String nmSeguradora;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "PK_MATRIZ")
    private Integer pkMatriz;

    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;

}
