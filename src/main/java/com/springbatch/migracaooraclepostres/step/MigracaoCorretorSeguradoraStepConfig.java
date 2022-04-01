package com.springbatch.migracaooraclepostres.step;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import com.springbatch.migracaooraclepostres.destino.domain.CorretorSeguradora;
import com.springbatch.migracaooraclepostres.origem.domain.CorretorOrigem;
import com.springbatch.migracaooraclepostres.origem.domain.CorretorSeguradoraOrigem;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MigracaoCorretorSeguradoraStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step migracaoCorretorSeguradoraStep(
            ItemReader<CorretorSeguradoraOrigem> dadosCorretorSeguradoraOrigemReader,
            ItemProcessor<CorretorSeguradoraOrigem, CorretorSeguradora> corretorSeguradoraProcessor,
            ItemWriter<CorretorSeguradora> corretorSeguradoraWriter
    ){
        return stepBuilderFactory
                .get("migracaoCorretorSeguradoraStep")
                .<CorretorSeguradoraOrigem, CorretorSeguradora>chunk(1)
                .reader(dadosCorretorSeguradoraOrigemReader)
                .processor(corretorSeguradoraProcessor)
                .writer(corretorSeguradoraWriter)
                .build();
    }

}
