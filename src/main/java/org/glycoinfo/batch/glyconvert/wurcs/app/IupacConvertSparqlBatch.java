package org.glycoinfo.batch.glyconvert.wurcs.app;

import org.glycoinfo.rdf.dao.virt.VirtSesameTransactionConfig;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(excludeFilters={
    @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=IupacCondensedConvertConfig.class)})
public class IupacConvertSparqlBatch {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ApplicationContext ctx = SpringApplication.run(IupacConvertSparqlBatch.class, args);
	}
}