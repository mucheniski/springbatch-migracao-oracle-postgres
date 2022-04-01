package com.springbatch.migracaooraclepostres.writer;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import com.springbatch.migracaooraclepostres.destino.domain.Seguradora;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SeguradoraWriterConfig {


    String sqlInsertSeguradora = " IINSERT INTO public.seguradora\n" +
                                " (id, nome_fantasia, cidade, estado)\n" +
                                " VALUES(?, ?, ?, ?)\n";

    String sqlInsertCorrtorSeguradora = " INSERT INTO public.corretor_seguradora\n" +
                                        " (id_corretor, id_seguradora)\n" +
                                        " VALUES(?, ?)";

//    @Bean
//    public JdbcBatchItemWriter<Corretor> dadosCorretorWriter(@Qualifier("destinoDataSource") DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Corretor>()
//                .dataSource(dataSource)
//                .sql(sqlInsertCorretor)
//                .itemPreparedStatementSetter(setarCampos())
//                .build();
//    }
//
//    private ItemPreparedStatementSetter<Corretor> setarCampos() {
//        return new ItemPreparedStatementSetter<Corretor>() {
//            @Override
//            public void setValues(Corretor corretor, PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setInt(1, corretor.getId());
//                preparedStatement.setString(2, corretor.getNome());
//                preparedStatement.setString(3, corretor.getCpf());
//            }
//        };
//    }



    /**
     * Usado apenas para testar se os dados estao sendo retornados da base origem corretamente
     */
    @Bean
    public ItemWriter<Seguradora> seguradoraWriter() {
        log.info("==========DADOS DAS SEGURADORAS==========");
        return itens -> itens.forEach(System.out::println);
    }

}