package com.springbatch.migracaooraclepostres.processor;

import com.springbatch.migracaooraclepostres.destino.domain.Produto;
import com.springbatch.migracaooraclepostres.destino.domain.Seguradora;
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
                produto.setDescricao(produtoOrigem.getDscProduto());
                produto.setValor(produtoOrigem.getVlrProduto());
                produto.setIdLegado(produtoOrigem.getCodProduto());
                produto.setSeguradoraLegadoId(produtoOrigem.getPkSeguradora());
                return produto;
            }
        };

    }

}
