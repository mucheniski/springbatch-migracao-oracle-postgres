package com.springbatch.migracaooraclepostres.processor;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import com.springbatch.migracaooraclepostres.destino.domain.CorretorSeguradora;
import com.springbatch.migracaooraclepostres.origem.domain.CorretorOrigem;
import com.springbatch.migracaooraclepostres.origem.domain.CorretorSeguradoraOrigem;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorretorSeguradoraProcessorConfig {

    @Bean
    public ItemProcessor<CorretorSeguradoraOrigem, CorretorSeguradora> corretorSeguradoraProcessor() {

        return new ItemProcessor<CorretorSeguradoraOrigem, CorretorSeguradora>() {
            @Override
            public CorretorSeguradora process(CorretorSeguradoraOrigem corretorSeguradoraOrigem) throws Exception {
                CorretorSeguradora corretorSeguradora = new CorretorSeguradora();
                corretorSeguradora.setIdCorretor(corretorSeguradoraOrigem.getPkCorretor());
                corretorSeguradora.setIdSeguradora(corretorSeguradoraOrigem.getPkSeguradora());
                return corretorSeguradora;
            }
        };

    }

}
