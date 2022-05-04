package com.springbatch.migracaooraclepostres.writer;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import com.springbatch.migracaooraclepostres.destino.domain.Seguradora;
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

@Slf4j
@Configuration
public class SeguradoraWriterConfig {


    String sqlInsertSeguradora = " INSERT INTO public.seguradora\n" +
                                " (nome_fantasia, cidade, estado, matriz_id, id_legado)\n" +
                                " VALUES(?, ?, ?, ?, ?)\n";

    @Bean
    public JdbcBatchItemWriter<Seguradora> seguradoraWriter(@Qualifier("destinoDataSource") DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Seguradora>()
                .dataSource(dataSource)
                .sql(sqlInsertSeguradora)
                .itemPreparedStatementSetter(setarCampos())
                .build();
    }

    private ItemPreparedStatementSetter<Seguradora> setarCampos() {
        return new ItemPreparedStatementSetter<Seguradora>() {
            @Override
            public void setValues(Seguradora seguradora, PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, seguradora.getNomeFantasia());
                preparedStatement.setString(2, seguradora.getCidade());
                preparedStatement.setString(3, seguradora.getEstado());
                preparedStatement.setInt(4, seguradora.getMatrizId());
                preparedStatement.setInt(5, seguradora.getIdLegado());
            }
        };
    }


    /**
     * Usado apenas para testar se os dados estao sendo retornados da base origem corretamente
     */
//    @Bean
//    public ItemWriter<Seguradora> seguradoraWriter() {
//        log.info("==========DADOS DAS SEGURADORAS==========");
//        return itens -> itens.forEach(System.out::println);
//    }

}
