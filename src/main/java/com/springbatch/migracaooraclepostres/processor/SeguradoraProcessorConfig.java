package com.springbatch.migracaooraclepostres.processor;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import com.springbatch.migracaooraclepostres.destino.domain.Seguradora;
import com.springbatch.migracaooraclepostres.origem.domain.DadosOrigem;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeguradoraProcessorConfig {

    @Bean
    public ItemProcessor<DadosOrigem, Seguradora> seguradoraProcessor() {

        return new ItemProcessor<DadosOrigem, Seguradora>() {
            @Override
            public Seguradora process(DadosOrigem dadosOrigem) throws Exception {
                Seguradora seguradora = new Seguradora();
                seguradora.setId(dadosOrigem.getPkSeguradora());
                seguradora.setNomeFantasia(dadosOrigem.getNmSeguradora());
                seguradora.setEstado(dadosOrigem.getEstado());
                seguradora.setCidade(dadosOrigem.getCidade());

                if (seguradora.getId() == dadosOrigem.getCorretorPkSeguradora()) {
                    Corretor corretor = new Corretor();
                    corretor.setId(dadosOrigem.getPkCorretor());
                    corretor.setNome(dadosOrigem.getNmCorretor());
                    corretor.setCpf(dadosOrigem.getCpfCorretor());
                    corretor.setPkSeguradora(dadosOrigem.getCorretorPkSeguradora());
                    seguradora.addCorretor(corretor);
                }

                return seguradora;
            }
        };

    }

}
