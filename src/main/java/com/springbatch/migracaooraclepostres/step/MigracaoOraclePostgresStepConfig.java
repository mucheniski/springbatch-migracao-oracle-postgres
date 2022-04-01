package com.springbatch.migracaooraclepostres.step;

import com.springbatch.migracaooraclepostres.origem.domain.DadosOrigem;
import com.springbatch.migracaooraclepostres.origem.domain.PessoaOrigem;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamReader;
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
            ItemStreamReader<PessoaOrigem> buscarPessoasReader,
            ItemWriter<PessoaOrigem> pessoaDestinoWriter
    ){
        return stepBuilderFactory
                .get("migracaoOraclePostgresStep")
                .<PessoaOrigem, PessoaOrigem>chunk(1)
                .reader(buscarPessoasReader)
                .writer(pessoaDestinoWriter)
                .build();
    }

}
