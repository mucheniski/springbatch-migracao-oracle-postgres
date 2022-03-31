package com.springbatch.migracaooraclepostres.step;

import com.springbatch.migracaooraclepostres.origem.domain.DadosOrigem;
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
//            ItemStreamReader<DadosOrigem> buscarPessoasReader,
//            ItemWriter<DadosOrigem> pessoaDestinoWriter
            ItemReader<DadosOrigem> dadosOrigemReader,
            ItemWriter<DadosOrigem> dadosOrigemWriter
    ){
        return stepBuilderFactory
                .get("migracaoOraclePostgresStep")
                .<DadosOrigem, DadosOrigem>chunk(1)
//                .reader(buscarPessoasReader)
//                .writer(pessoaDestinoWriter)
                .reader(dadosOrigemReader)
                .writer(dadosOrigemWriter)
                .build();
    }

}
