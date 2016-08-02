package org.glycoinfo.batch.glyconvert.wurcs.iupac.extended;

import org.glycoinfo.batch.glyconvert.wurcs.iupac.IupacConvertJobConfig;
import org.glycoinfo.batch.glyconvert.wurcs.iupac.condensed.IupacCondensedConvertConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({IupacConvertJobConfig.class})
public class IupacConvertSparqlBatch {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ApplicationContext ctx = SpringApplication.run(IupacConvertSparqlBatch.class, args);
	}
}