package com.springbatch.migracaooraclepostres.step;

import com.springbatch.migracaooraclepostres.domain.Pessoa;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MigracaoOraclePostgresStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step migracaoOraclePostgresStep(
            ItemReader<Pessoa> pessoaOrigemReader,
//            ItemWriter<Pessoa> pessoaDestinoWriter
            ItemWriter<Pessoa> pessoaOrigemWriter
    ){
        return stepBuilderFactory
                .get("migracaoOraclePostgresStep")
                .<Pessoa, Pessoa>chunk(1)
                .reader(pessoaOrigemReader)
//                .writer(pessoaDestinoWriter)
                .writer(pessoaOrigemWriter)
                .build();
    }

}
