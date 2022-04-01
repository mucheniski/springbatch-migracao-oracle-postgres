package com.springbatch.migracaooraclepostres.writer;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import com.springbatch.migracaooraclepostres.destino.domain.Produto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ProdutoWriterConfig {


    String sqlInsertProduto = " INSERT INTO public.produto\n" +
                                " (id, descricao, valor, id_seguradora)\n" +
                                " VALUES(?, ?, ?, ?);\n";

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
    public ItemWriter<Produto> produtoWriter() {
        log.info("==========DADOS DOS PRODUTOS==========");
        return itens -> itens.forEach(System.out::println);
    }

}
