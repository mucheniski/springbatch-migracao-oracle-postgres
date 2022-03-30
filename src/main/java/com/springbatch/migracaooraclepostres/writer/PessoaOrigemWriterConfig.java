package com.springbatch.migracaooraclepostres.writer;

import com.springbatch.migracaooraclepostres.domain.Pessoa;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PessoaOrigemWriterConfig {

    @Bean
    public ItemWriter<Pessoa> pessoaOrigemWriter() {
        return pessoas -> pessoas.forEach(System.out::println);
    }

}
