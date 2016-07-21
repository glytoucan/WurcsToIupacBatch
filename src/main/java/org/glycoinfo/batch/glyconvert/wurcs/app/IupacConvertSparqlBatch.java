package org.glycoinfo.batch.glyconvert.wurcs.app;

import org.glycoinfo.batch.glyconvert.GlyConvertSparqlItemConfig;
import org.springframework.boot.SpringApplication;
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