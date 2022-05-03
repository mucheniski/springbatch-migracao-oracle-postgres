package com.springbatch.migracaooraclepostres.processor;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import com.springbatch.migracaooraclepostres.origem.domain.CorretorOrigem;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorretorProcessorConfig {

    @Bean
    public ItemProcessor<CorretorOrigem, Corretor> corretorProcessor() {

        return new ItemProcessor<CorretorOrigem, Corretor>() {
            @Override
            public Corretor process(CorretorOrigem corretorOrigem) throws Exception {
                Corretor corretor = new Corretor();
                corretor.setNome(corretorOrigem.getNmCorretor());
                corretor.setCpf(corretorOrigem.getCpfCorretor());
                corretor.setIdLegado(corretorOrigem.getPkCorretor());
                return corretor;
            }
        };

    }

}
