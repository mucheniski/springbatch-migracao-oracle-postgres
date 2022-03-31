package com.springbatch.migracaooraclepostres.reader;

import com.springbatch.migracaooraclepostres.origem.domain.PessoaOrigem;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.batch.item.database.orm.JpaNamedQueryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
public class PessoaOrigemReaderConfig {

    @Bean(destroyMethod = "")
    public JpaPagingItemReader<PessoaOrigem> buscarPessoasReader(EntityManagerFactory entityManagerFactory) {

        JpaNamedQueryProvider<PessoaOrigem> jpaNamedQueryProvider = new JpaNamedQueryProvider<PessoaOrigem>();
        jpaNamedQueryProvider.setEntityClass(PessoaOrigem.class);
        jpaNamedQueryProvider.setNamedQuery("buscarPessoas");

        return  new JpaPagingItemReaderBuilder<PessoaOrigem>()
                .name("buscarPessoasReader")
                .queryProvider(jpaNamedQueryProvider)
                .entityManagerFactory(entityManagerFactory)
                // set other properties on the reader
                .build();

    }

}
