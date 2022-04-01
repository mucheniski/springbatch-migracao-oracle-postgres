package com.springbatch.migracaooraclepostres.step;

import com.springbatch.migracaooraclepostres.destino.domain.Produto;
import com.springbatch.migracaooraclepostres.origem.domain.DadosOrigem;
import com.springbatch.migracaooraclepostres.origem.domain.ProdutoOrigem;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MigracaoProdutoStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step migracaoProdutoStep(
            ItemReader<ProdutoOrigem> produtoOrigemReader,
            ItemProcessor<ProdutoOrigem, Produto> produtoProcessor,
            ItemWriter<Produto> produtoWriter
    ){
        return stepBuilderFactory
                .get("migracaoProdutoStep")
                .<ProdutoOrigem, Produto>chunk(1)
                .reader(produtoOrigemReader)
                .processor(produtoProcessor)
                .writer(produtoWriter)
                .build();
    }

}
