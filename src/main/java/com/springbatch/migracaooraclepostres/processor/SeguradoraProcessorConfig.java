package com.springbatch.migracaooraclepostres.processor;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import com.springbatch.migracaooraclepostres.destino.domain.Seguradora;
import com.springbatch.migracaooraclepostres.origem.domain.DadosOrigem;
import com.springbatch.migracaooraclepostres.origem.domain.SeguradoraOrigem;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeguradoraProcessorConfig {

    @Bean
    public ItemProcessor<SeguradoraOrigem, Seguradora> seguradoraProcessor() {

        return new ItemProcessor<SeguradoraOrigem, Seguradora>() {
            @Override
            public Seguradora process(SeguradoraOrigem seguradoraOrigem) throws Exception {
                Seguradora seguradora = new Seguradora();
                seguradora.setId(seguradoraOrigem.getPkSeguradora());
                seguradora.setNomeFantasia(seguradoraOrigem.getNmSeguradora());
                seguradora.setEstado(seguradoraOrigem.getEstado());
                seguradora.setCidade(seguradoraOrigem.getCidade());
                seguradora.setMatrizId(seguradoraOrigem.getPkMatriz());
                return seguradora;
            }
        };

    }

}
