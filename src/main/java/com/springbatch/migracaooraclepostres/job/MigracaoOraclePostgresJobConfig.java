package com.springbatch.migracaooraclepostres.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class MigracaoOraclePostgresJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job migracaoOraclePostgresJob(
            @Qualifier("migracaoCorretorStep") Step migracaoCorretorStep,
            @Qualifier("migracaoSeguradoraStep") Step migracaoSeguradoraStep,
            @Qualifier("migracaoProdutoStep") Step migracaoProdutoStep,
            @Qualifier("migracaoCorretorSeguradoraStep") Step migracaoCorretorSeguradoraStep) {
        return jobBuilderFactory
                .get("migracaoOraclePostgresJob")
                .start(migracaoCorretorStep)
                .next(migracaoSeguradoraStep)
                .next(migracaoProdutoStep)
                .next(migracaoCorretorSeguradoraStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}
