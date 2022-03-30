package com.springbatch.migracaooraclepostres.writer;

import com.springbatch.migracaooraclepostres.domain.Pessoa;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PessoaOrgiemWriterConfig {

    @Bean
    public ItemWriter<Pessoa> jdbcCursorWriter() {
        return itens -> itens.forEach(System.out::println);
    }

}
