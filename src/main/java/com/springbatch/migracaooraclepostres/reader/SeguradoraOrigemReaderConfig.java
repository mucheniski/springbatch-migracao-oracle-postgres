package com.springbatch.migracaooraclepostres.reader;

import com.springbatch.migracaooraclepostres.origem.domain.SeguradoraOrigem;
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
public class SeguradoraOrigemReaderConfig {

    String sqlSelect = " SELECT SEGURADORA.PK_SEGURADORA,\n" +
                        " SEGURADORA.NM_SEGURADORA,\n" +
                        " SEGURADORA.CIDADE,\n" +
                        " SEGURADORA.ESTADO,\n" +
                        " SEGURADORA.PK_MATRIZ\n" +
                        " FROM SEGURADORA";

    @Bean
    JdbcCursorItemReader<SeguradoraOrigem> seguradoraOrigemReader(@Qualifier("origemDataSource") DataSource dataSource){
        return new JdbcCursorItemReaderBuilder<SeguradoraOrigem>()
                .name("seguradoraOrigemReader")
                .dataSource(dataSource)
                .sql(sqlSelect)
                .rowMapper(mapeadorColunas())
                .build();
    }

    private RowMapper<SeguradoraOrigem> mapeadorColunas() {

        return new RowMapper<SeguradoraOrigem>() {
            @Override
            public SeguradoraOrigem mapRow(ResultSet rs, int rowNum) throws SQLException {

                SeguradoraOrigem seguradoraOrigem = new SeguradoraOrigem();
                seguradoraOrigem.setPkSeguradora(rs.getInt("PK_SEGURADORA"));
                seguradoraOrigem.setNmSeguradora(rs.getString("NM_SEGURADORA"));
                seguradoraOrigem.setCidade(rs.getString("CIDADE"));
                seguradoraOrigem.setEstado(rs.getString("ESTADO"));
                seguradoraOrigem.setPkMatriz(rs.getInt("PK_MATRIZ"));
                return seguradoraOrigem;

            }
        };
    }

}
