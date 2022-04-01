package com.springbatch.migracaooraclepostres.step;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
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
public class MigracaoCorretorStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step migracaoCorretorStep(
            ItemReader<DadosOrigem> dadosOrigemReader,
            ItemProcessor<DadosOrigem, Corretor> corretorProcessor,
            ItemWriter<Corretor> dadosCorretorWriter
    ){
        return stepBuilderFactory
                .get("migracaoOraclePostgresStep")
                .<DadosOrigem, Corretor>chunk(1)
                .reader(dadosOrigemReader)
                .processor(corretorProcessor)
                .writer(dadosCorretorWriter)
                .build();
    }

}
