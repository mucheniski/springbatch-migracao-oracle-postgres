package com.springbatch.migracaooraclepostres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;

@SpringBootApplication()
@EntityScan("com.springbatch")
public class MigracaoOraclePostresApplication {

	public static void main(String[] args) {
		SpringApplication.run(MigracaoOraclePostresApplication.class, args);
	}

}
