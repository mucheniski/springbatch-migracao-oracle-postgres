package com.springbatch.migracaooraclepostres.reader;

import com.springbatch.migracaooraclepostres.origem.domain.DadosOrigem;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class DadosOrigemReaderConfig {

    String sqlSelect = "SELECT CORRET_SEG_PROD.PK_CORRETOR,\n" +
            "\t   CORRET_SEG_PROD.NM_CORRETOR,\n" +
            "\t   CORRET_SEG_PROD.CPF_CORRETOR,\n" +
            "\t   CORRET_SEG_PROD.COD_PRODUTO,\n" +
            "\t   CORRET_SEG_PROD.DSC_PRODUTO,\n" +
            "\t   CORRET_SEG_PROD.VLR_PRODUTO,\n" +
            "\t   CORRET_SEG_PROD.PK_SEGURADORA CORRETOR_PK_SEGURADORA,\n" +
            "\t   SEGURADORA.PK_SEGURADORA,\n" +
            "\t   SEGURADORA.NM_SEGURADORA,\n" +
            "\t   SEGURADORA.CIDADE,\n" +
            "\t   SEGURADORA.ESTADO,\n" +
            "\t   MATRIZ.PK_MATRIZ,\n" +
            "\t   MATRIZ.RAZAO_SOCIAL\t   \n" +
            "FROM\n" +
            "CORRET_SEG_PROD INNER JOIN SEGURADORA\n" +
            "ON CORRET_SEG_PROD.PK_SEGURADORA = SEGURADORA.PK_SEGURADORA\n" +
            "INNER JOIN MATRIZ\n" +
            "ON MATRIZ.PK_MATRIZ = SEGURADORA.PK_MATRIZ";

    @Bean
    JdbcCursorItemReader<DadosOrigem> dadosOrigemReader(@Qualifier("origemDataSource") DataSource dataSource){
        return new JdbcCursorItemReaderBuilder<DadosOrigem>()
                .name("dadosOrigemReader")
                .dataSource(dataSource)
                .sql(sqlSelect)
                .rowMapper(mapeadorColunas())
                .build();
    }

    private RowMapper<DadosOrigem> mapeadorColunas() {

        return new RowMapper<DadosOrigem>() {
            @Override
            public DadosOrigem mapRow(ResultSet rs, int rowNum) throws SQLException {

                DadosOrigem dadosOrigem = new DadosOrigem();
                dadosOrigem.setPkCorretor(rs.getInt("PK_CORRETOR"));
                dadosOrigem.setNmCorretor(rs.getString("NM_CORRETOR"));
                dadosOrigem.setCpfCorretor(rs.getString("CPF_CORRETOR"));
                dadosOrigem.setCodProduto(rs.getInt("COD_PRODUTO"));
                dadosOrigem.setDscProduto(rs.getString("DSC_PRODUTO"));
                dadosOrigem.setVlrProduto(rs.getDouble("VLR_PRODUTO"));
                dadosOrigem.setCorretorPkSeguradora(rs.getInt("CORRETOR_PK_SEGURADORA"));
                dadosOrigem.setPkSeguradora(rs.getInt("PK_SEGURADORA"));
                dadosOrigem.setNmSeguradora(rs.getString("NM_SEGURADORA"));
                dadosOrigem.setCidade(rs.getString("CIDADE"));
                dadosOrigem.setEstado(rs.getString("ESTADO"));
                dadosOrigem.setPkMatriz(rs.getInt("PK_MATRIZ"));
                dadosOrigem.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
                return dadosOrigem;

            }
        };
    }

}
