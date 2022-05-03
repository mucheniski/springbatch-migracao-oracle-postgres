package com.springbatch.migracaooraclepostres.writer;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Configuration
public class CorretorWriterConfig {

    String sqlInsertCorretor = " INSERT INTO public.corretor\n" +
                        " (nome, cpf, id_legado)\n" +
                        " VALUES(?, ?, ?)";

    @Bean
    public JdbcBatchItemWriter<Corretor> corretorWriter(@Qualifier("destinoDataSource") DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Corretor>()
                .dataSource(dataSource)
                .sql(sqlInsertCorretor)
                .itemPreparedStatementSetter(setarCampos())
                .build();
    }

    private ItemPreparedStatementSetter<Corretor> setarCampos() {
        return new ItemPreparedStatementSetter<Corretor>() {
            @Override
            public void setValues(Corretor corretor, PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, corretor.getNome());
                preparedStatement.setString(2, corretor.getCpf());
                preparedStatement.setInt(3, corretor.getIdLegado());
            }
        };
    }


    /**
     * Usado apenas para testar se os dados estao sendo retornados da base origem corretamente
     */
//    @Bean
//    public ItemWriter<Corretor> corretorWriter() {
//        log.info("==========DADOS DOS CORRETORES==========");
//        return itens -> itens.forEach(System.out::println);
//    }

}
