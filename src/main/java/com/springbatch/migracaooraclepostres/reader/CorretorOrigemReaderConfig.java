package com.springbatch.migracaooraclepostres.reader;

import com.springbatch.migracaooraclepostres.origem.domain.CorretorOrigem;
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
public class CorretorOrigemReaderConfig {

    String sqlSelect =  " SELECT DISTINCT(PK_CORRETOR) PK_CORRETOR, \n" +
                        " NM_CORRETOR, \n" +
                        " CPF_CORRETOR\n" +
                        " FROM CORRET_SEG_PROD";

    @Bean
    JdbcCursorItemReader<CorretorOrigem> dadosCorretorOrigemReader(@Qualifier("origemDataSource") DataSource dataSource){
        return new JdbcCursorItemReaderBuilder<CorretorOrigem>()
                .name("dadosCorretorOrigemReader")
                .dataSource(dataSource)
                .sql(sqlSelect)
                .rowMapper(mapeadorColunas())
                .build();
    }

    private RowMapper<CorretorOrigem> mapeadorColunas() {

        return new RowMapper<CorretorOrigem>() {
            @Override
            public CorretorOrigem mapRow(ResultSet rs, int rowNum) throws SQLException {

                CorretorOrigem corretorOrigem = new CorretorOrigem();
                corretorOrigem.setPkCorretor(rs.getInt("PK_CORRETOR"));
                corretorOrigem.setNmCorretor(rs.getString("NM_CORRETOR"));
                corretorOrigem.setCpfCorretor(rs.getString("CPF_CORRETOR"));

                return corretorOrigem;

            }
        };
    }

}
