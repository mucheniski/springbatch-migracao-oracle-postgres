//package com.springbatch.migracaooraclepostres.writer;
//
//import com.springbatch.migracaooraclepostres.origem.domain.PessoaOrigem;
//import org.springframework.batch.item.database.ItemPreparedStatementSetter;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//@Configuration
//public class PessoaDestinoWriterConfig {
//
//    String sqlInsert = " INSERT INTO public.pessoa_destino\n" +
//                        " (id, nome)\n" +
//                        " VALUES(?, ?)\n";
//
//    @Bean
//    public JdbcBatchItemWriter<PessoaOrigem> PessoaOrigemWriter(@Qualifier("destinoDataSource") DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<PessoaOrigem>()
//                .dataSource(dataSource)
//                .sql(sqlInsert)
//                .itemPreparedStatementSetter(setarCampos())
//                .build();
//    }
//
//    private ItemPreparedStatementSetter<PessoaOrigem> setarCampos() {
//        return new ItemPreparedStatementSetter<PessoaOrigem>() {
//            @Override
//            public void setValues(PessoaOrigem PessoaOrigem, PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setInt(1, PessoaOrigem.getPkPessoa());
//                preparedStatement.setString(2, PessoaOrigem.getNmPessoa());
//            }
//        };
//    }
//
//}
