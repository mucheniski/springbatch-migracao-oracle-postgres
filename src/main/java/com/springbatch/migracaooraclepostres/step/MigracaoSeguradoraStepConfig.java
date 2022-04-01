package com.springbatch.migracaooraclepostres.step;

import com.springbatch.migracaooraclepostres.destino.domain.Seguradora;
import com.springbatch.migracaooraclepostres.origem.domain.DadosOrigem;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MigracaoSeguradoraStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step migracaoSeguradoraStep(
            ItemReader<DadosOrigem> dadosOrigemReader,
            ItemProcessor<DadosOrigem, Seguradora> seguradoraProcessor,
            ItemWriter<Seguradora> seguradoraWriter
    ){
        return stepBuilderFactory
                .get("migracaoSeguradoraStep")
                .<DadosOrigem, Seguradora>chunk(1)
                .reader(dadosOrigemReader)
                .processor(seguradoraProcessor)
                .writer(seguradoraWriter)
                .build();
    }

}
