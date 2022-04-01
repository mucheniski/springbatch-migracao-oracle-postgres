package com.springbatch.migracaooraclepostres.writer;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import com.springbatch.migracaooraclepostres.destino.domain.Produto;
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
public class ProdutoWriterConfig {


    String sqlInsertProduto = " INSERT INTO public.produto\n" +
                              " (id, descricao, valor, id_seguradora)\n" +
                              " VALUES(?, ?, ?, ?);\n";

    @Bean
    public JdbcBatchItemWriter<Produto> dadosCorretorWriter(@Qualifier("destinoDataSource") DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Produto>()
                .dataSource(dataSource)
                .sql(sqlInsertProduto)
                .itemPreparedStatementSetter(setarCampos())
                .build();
    }

    private ItemPreparedStatementSetter<Produto> setarCampos() {
        return new ItemPreparedStatementSetter<Produto>() {
            @Override
            public void setValues(Produto produto, PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, produto.getId());
                preparedStatement.setString(2, produto.getDescricao());
                preparedStatement.setDouble(3, produto.getValor());
                preparedStatement.setInt(4, produto.getSeguradoraId());
            }
        };
    }



    /**
     * Usado apenas para testar se os dados estao sendo retornados da base origem corretamente
     */
//    @Bean
//    public ItemWriter<Produto> produtoWriter() {
//        log.info("==========DADOS DOS PRODUTOS==========");
//        return itens -> itens.forEach(System.out::println);
//    }

}
