package com.springbatch.migracaooraclepostres.writer;

import com.springbatch.migracaooraclepostres.domain.Pessoa;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class PessoaDestinoWriterConfig {

    String sqlInsert = " INSERT INTO public.pessoa_destino\n" +
                        " (id, nome)\n" +
                        " VALUES(?, ?)\n";

    @Bean
    public JdbcBatchItemWriter<Pessoa> pessoaDestinoWriter(@Qualifier("appDataSource") DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Pessoa>()
                .dataSource(dataSource)
                .sql(sqlInsert)
                .itemPreparedStatementSetter(setarCampos())
                .build();
    }

    private ItemPreparedStatementSetter<Pessoa> setarCampos() {
        return new ItemPreparedStatementSetter<Pessoa>() {
            @Override
            public void setValues(Pessoa pessoa, PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, pessoa.getId());
                preparedStatement.setString(2, pessoa.getNome());
            }
        };
    }

}
