package com.springbatch.migracaooraclepostres.processor;

import com.springbatch.migracaooraclepostres.destino.domain.Corretor;
import com.springbatch.migracaooraclepostres.destino.domain.Produto;
import com.springbatch.migracaooraclepostres.destino.domain.Seguradora;
import com.springbatch.migracaooraclepostres.origem.domain.DadosOrigem;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoProcessorConfig {

    @Bean
    public ItemProcessor<DadosOrigem, Produto> produtoProcessor() {

        return new ItemProcessor<DadosOrigem, Produto>() {
            @Override
            public Produto process(DadosOrigem dadosOrigem) throws Exception {
                Produto produto = new Produto();
                produto.setId(dadosOrigem.getCodProduto());
                produto.setDescricao(dadosOrigem.getDscProduto());
                produto.setValor(dadosOrigem.getVlrProduto());
                produto.setSeguradoraId(dadosOrigem.getPkSeguradora());
                return produto;
            }
        };

    }

}
