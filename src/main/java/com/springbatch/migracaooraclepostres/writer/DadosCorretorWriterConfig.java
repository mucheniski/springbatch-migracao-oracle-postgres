package com.springbatch.migracaooraclepostres.writer;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DadosCorretorWriterConfig {






    /**
     * Usado apenas para testar se os dados estao sendo retornados da base origem corretamente
     */
    @Bean
    public ItemWriter<Corretor> dadosCorretorWriter() {
        log.info("==========DADOS DOS CORRETORES==========");
        return itens -> itens.forEach(System.out::println);
    }

}
