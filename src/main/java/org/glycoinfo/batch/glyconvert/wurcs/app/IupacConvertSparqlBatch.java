package org.glycoinfo.batch.glyconvert.wurcs.app;

import org.glycoinfo.rdf.dao.virt.VirtSesameTransactionConfig;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = ("org.glycoinfo.batch.rdf"))
@EnableBatchProcessing
@Import(VirtSesameTransactionConfig.class)
public class IupacConvertSparqlBatch {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ApplicationContext ctx = SpringApplication.run(IupacConvertSparqlBatch.class, args);
	}
}