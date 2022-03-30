package com.springbatch.migracaooraclepostres.reader;

import com.springbatch.migracaooraclepostres.domain.PessoaOrigem;
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
public class PessoaOrigemReaderConfig {

    @Bean
    JdbcCursorItemReader<PessoaOrigem> pessoaOrigemReader(@Qualifier("appDataSource") DataSource dataSource){
        return new JdbcCursorItemReaderBuilder<PessoaOrigem>()
                .name("pessoaOrigemReader")
                .dataSource(dataSource)
                .sql("select * from pessoa_origem")
                .rowMapper(mapeadorColunas())
                .build();
    }

    private RowMapper<PessoaOrigem> mapeadorColunas() {

        return new RowMapper<PessoaOrigem>() {
            @Override
            public PessoaOrigem mapRow(ResultSet rs, int rowNum) throws SQLException {
                PessoaOrigem pessoa = new PessoaOrigem();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                return pessoa;
            }
        };

    }

}
