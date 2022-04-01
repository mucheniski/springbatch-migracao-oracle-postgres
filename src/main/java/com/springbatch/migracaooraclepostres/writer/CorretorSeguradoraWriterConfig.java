package com.springbatch.migracaooraclepostres.writer;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import com.springbatch.migracaooraclepostres.destino.domain.CorretorSeguradora;
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
public class CorretorSeguradoraWriterConfig {

    String sqlInsertCorretorSeguradora = " INSERT INTO public.corretor_seguradora\n" +
                                         " (id_corretor, id_seguradora)\n" +
                                         " VALUES(?, ?)\n";

    @Bean
    public JdbcBatchItemWriter<CorretorSeguradora> corretorSeguradoraWriter(@Qualifier("destinoDataSource") DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<CorretorSeguradora>()
                .dataSource(dataSource)
                .sql(sqlInsertCorretorSeguradora)
                .itemPreparedStatementSetter(setarCampos())
                .build();
    }

    private ItemPreparedStatementSetter<CorretorSeguradora> setarCampos() {
        return new ItemPreparedStatementSetter<CorretorSeguradora>() {
            @Override
            public void setValues(CorretorSeguradora corretorSeguradora, PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, corretorSeguradora.getIdCorretor());
                preparedStatement.setInt(2, corretorSeguradora.getIdSeguradora());
            }
        };
    }


    /**
     * Usado apenas para testar se os dados estao sendo retornados da base origem corretamente
     */
//    @Bean
//    public ItemWriter<CorretorSeguradora> corretorSeguradoraWriter() {
//        log.info("==========DADOS DOS CORRETORES==========");
//        return itens -> itens.forEach(System.out::println);
//    }

}
