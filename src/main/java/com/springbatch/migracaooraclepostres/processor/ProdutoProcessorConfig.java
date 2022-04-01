package com.springbatch.migracaooraclepostres.processor;

import com.springbatch.migracaooraclepostres.destino.domain.Produto;
import com.springbatch.migracaooraclepostres.origem.domain.ProdutoOrigem;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoProcessorConfig {

    @Bean
    public ItemProcessor<ProdutoOrigem, Produto> produtoProcessor() {

        return new ItemProcessor<ProdutoOrigem, Produto>() {
            @Override
            public Produto process(ProdutoOrigem produtoOrigem) throws Exception {
                Produto produto = new Produto();
                produto.setId(produtoOrigem.getCodProduto());
                produto.setDescricao(produtoOrigem.getDscProduto());
                produto.setValor(produtoOrigem.getVlrProduto());
                produto.setSeguradoraId(produtoOrigem.getPkSeguradora());
                return produto;
            }
        };

    }

}
