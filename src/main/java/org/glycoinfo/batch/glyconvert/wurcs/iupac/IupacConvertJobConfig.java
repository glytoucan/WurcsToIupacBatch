package org.glycoinfo.batch.glyconvert.wurcs.iupac;

import org.glycoinfo.batch.glyconvert.ConvertSparqlProcessor;
import org.glycoinfo.batch.glyconvert.GlyConvertSparqlItemConfig;
import org.glycoinfo.rdf.dao.SparqlEntity;
import org.glycoinfo.rdf.dao.virt.VirtSesameTransactionConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableBatchProcessing
@Import({VirtSesameTransactionConfig.class, GlyConvertSparqlItemConfig.class})
public class IupacConvertJobConfig {

//  @Autowired
//  ConvertSparqlProcessor convertSparqlProcessor;

	// graph base to set the graph to insert into. The format type (toFormat())
	// will be added to the end.
	public static String graphbase = "http://rdf.glytoucan.org/sequence";

	@Bean
	public Job importUserJob(JobBuilderFactory jobs, Step s1) {
//	  return jobs.get("ConvertWurcs").incrementer(new RunIdIncrementer()).flow(s1).end().build();
	  return jobs.get("ConvertWurcs").incrementer(new RunIdIncrementer()).flow(s1).end().build();
	}

	@Bean
	public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<SparqlEntity> reader,
			ItemWriter<SparqlEntity> writer, ItemProcessor<SparqlEntity, SparqlEntity> processor) {
		return stepBuilderFactory.get("step1").<SparqlEntity, SparqlEntity> chunk(10).reader(reader)
				.processor(processor).writer(writer).build();
	}
	
//  @Bean
//  public ItemProcessor<SparqlEntity, SparqlEntity> processor() {
//    return convertSparqlProcessor;
//  }
//  
//  @Bean
//  public ConvertSparqlProcessor convertSparqlProcessor() {
//    return new ConvertSparqlProcessor();
//  }
}