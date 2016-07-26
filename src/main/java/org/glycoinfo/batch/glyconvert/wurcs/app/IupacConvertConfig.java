package org.glycoinfo.batch.glyconvert.wurcs.app;

import org.glycoinfo.batch.glyconvert.ConvertInsertSparql;
import org.glycoinfo.batch.glyconvert.ConvertSelectSparql;
import org.glycoinfo.convert.GlyConvert;
import org.glycoinfo.convert.wurcs.WurcsToIupacConverter;
import org.glycoinfo.rdf.InsertSparql;
import org.glycoinfo.rdf.SelectSparql;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IupacConvertConfig {

	// graph base to set the graph to insert into. The format type (toFormat())
	// will be added to the end.
	public static String graphbase = "http://rdf.glytoucan.org/sequence";

  @Bean(name="org.glycoinfo.batch.glyconvert")
	GlyConvert getGlyConvert() {
		return new WurcsToIupacConverter();
	}
	
	@Bean(name = "itemReaderSelectSparql")
	SelectSparql itemReaderSelectSparql() {
		SelectSparql select = new ConvertSelectSparql();
		select.setFrom("FROM <http://rdf.glytoucan.org> FROM <http://rdf.glytoucan.org/sequence/wurcs> FROM <https://rdf.glytoucan.org/sequence/iupac>");
		return select;
	}

	@Bean(name = "itemWriterInsertSparql")
	InsertSparql getInsertSparql() {
		ConvertInsertSparql convert = new ConvertInsertSparql();
		convert.setGraphBase(graphbase);
		return convert;
	}
}
