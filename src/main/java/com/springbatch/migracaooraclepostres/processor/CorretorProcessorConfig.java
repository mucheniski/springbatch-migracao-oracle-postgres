package com.springbatch.migracaooraclepostres.processor;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import com.springbatch.migracaooraclepostres.origem.domain.DadosOrigem;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorretorProcessorConfig {

    @Bean
    public ItemProcessor<DadosOrigem, Corretor> corretorProcessor() {

        return new ItemProcessor<DadosOrigem, Corretor>() {
            @Override
            public Corretor process(DadosOrigem dadosOrigem) throws Exception {
                Corretor corretor = new Corretor();
                corretor.setId(dadosOrigem.getPkCorretor());
                corretor.setNome(dadosOrigem.getNmCorretor());
                corretor.setCpf(dadosOrigem.getCpfCorretor());
                return corretor;
            }
        };

    }

}
