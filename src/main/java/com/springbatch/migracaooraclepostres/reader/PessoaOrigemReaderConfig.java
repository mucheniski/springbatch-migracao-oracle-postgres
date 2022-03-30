package com.springbatch.migracaooraclepostres.reader;

import com.springbatch.migracaooraclepostres.domain.Pessoa;
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
    JdbcCursorItemReader<Pessoa> pessoaOrigemReader(@Qualifier("appDataSource") DataSource dataSource){
        return new JdbcCursorItemReaderBuilder<Pessoa>()
                .name("pessoaOrigemReader")
                .dataSource(dataSource)
                .sql("select * from appspringbatch.pessoa_origem")
                .rowMapper(mapeadorColunas())
                .build();
    }

    private RowMapper<Pessoa> mapeadorColunas() {

        return new RowMapper<Pessoa>() {
            @Override
            public Pessoa mapRow(ResultSet rs, int rowNum) throws SQLException {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                return pessoa;
            }
        };

    }

}
