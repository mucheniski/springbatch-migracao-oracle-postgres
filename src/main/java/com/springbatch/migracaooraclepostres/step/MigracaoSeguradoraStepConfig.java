package com.springbatch.migracaooraclepostres.step;

import com.springbatch.migracaooraclepostres.destino.domain.Seguradora;
import com.springbatch.migracaooraclepostres.origem.domain.DadosOrigem;
import com.springbatch.migracaooraclepostres.origem.domain.SeguradoraOrigem;
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
            ItemReader<SeguradoraOrigem> seguradoraOrigemReader,
            ItemProcessor<SeguradoraOrigem, Seguradora> seguradoraProcessor,
            ItemWriter<Seguradora> seguradoraWriter
    ){
        return stepBuilderFactory
                .get("migracaoSeguradoraStep")
                .<SeguradoraOrigem, Seguradora>chunk(1)
                .reader(seguradoraOrigemReader)
                .processor(seguradoraProcessor)
                .writer(seguradoraWriter)
                .build();
    }

}
