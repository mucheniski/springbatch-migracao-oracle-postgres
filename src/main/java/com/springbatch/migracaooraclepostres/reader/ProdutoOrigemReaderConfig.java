package com.springbatch.migracaooraclepostres.reader;

import com.springbatch.migracaooraclepostres.origem.domain.DadosOrigem;
import com.springbatch.migracaooraclepostres.origem.domain.ProdutoOrigem;
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
public class ProdutoOrigemReaderConfig {

    String sqlSelect =  " SELECT CORRET_SEG_PROD.COD_PRODUTO,\n" +
                        " CORRET_SEG_PROD.DSC_PRODUTO,\n" +
                        " CORRET_SEG_PROD.VLR_PRODUTO,\n" +
                        " CORRET_SEG_PROD.PK_SEGURADORA\n" +
                        " FROM CORRET_SEG_PROD";

    @Bean
    JdbcCursorItemReader<ProdutoOrigem> produtoOrigemReader(@Qualifier("origemDataSource") DataSource dataSource){
        return new JdbcCursorItemReaderBuilder<ProdutoOrigem>()
                .name("produtoOrigemReader")
                .dataSource(dataSource)
                .sql(sqlSelect)
                .rowMapper(mapeadorColunas())
                .build();
    }

    private RowMapper<ProdutoOrigem> mapeadorColunas() {

        return new RowMapper<ProdutoOrigem>() {
            @Override
            public ProdutoOrigem mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProdutoOrigem produtoOrigem = new ProdutoOrigem();
                produtoOrigem.setCodProduto(rs.getInt("COD_PRODUTO"));
                produtoOrigem.setDscProduto(rs.getString("DSC_PRODUTO"));
                produtoOrigem.setVlrProduto(rs.getDouble("VLR_PRODUTO"));
                produtoOrigem.setPkSeguradora(rs.getInt("PK_SEGURADORA"));
                return produtoOrigem;
            }
        };
    }

}
