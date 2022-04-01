package com.springbatch.migracaooraclepostres.reader;

import com.springbatch.migracaooraclepostres.origem.domain.CorretorOrigem;
import com.springbatch.migracaooraclepostres.origem.domain.CorretorSeguradoraOrigem;
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
public class CorretorSeguradoraOrigemReaderConfig {

    String sqlSelect =  " SELECT PK_CORRETOR, \n" +
                        " PK_SEGURADORA \n" +
                        " FROM CORRET_SEG_PROD";

    @Bean
    JdbcCursorItemReader<CorretorSeguradoraOrigem> dadosCorretorSeguradoraOrigemReader(@Qualifier("origemDataSource") DataSource dataSource){
        return new JdbcCursorItemReaderBuilder<CorretorSeguradoraOrigem>()
                .name("dadosCorretorSeguradoraOrigemReader")
                .dataSource(dataSource)
                .sql(sqlSelect)
                .rowMapper(mapeadorColunas())
                .build();
    }

    private RowMapper<CorretorSeguradoraOrigem> mapeadorColunas() {

        return new RowMapper<CorretorSeguradoraOrigem>() {
            @Override
            public CorretorSeguradoraOrigem mapRow(ResultSet rs, int rowNum) throws SQLException {
                CorretorSeguradoraOrigem corretorSeguradoraOrigem = new CorretorSeguradoraOrigem();
                corretorSeguradoraOrigem.setPkCorretor(rs.getInt("PK_CORRETOR"));
                corretorSeguradoraOrigem.setPkSeguradora(rs.getInt("PK_SEGURADORA"));
                return corretorSeguradoraOrigem;
            }
        };
    }

}
