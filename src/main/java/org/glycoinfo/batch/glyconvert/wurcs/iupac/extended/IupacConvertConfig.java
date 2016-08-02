package org.glycoinfo.batch.glyconvert.wurcs.iupac.extended;

import org.glycoinfo.batch.glyconvert.ConvertInsertSparql;
import org.glycoinfo.batch.glyconvert.ConvertSelectSparql;
import org.glycoinfo.batch.glyconvert.GlyConvertSparqlItemConfig;
import org.glycoinfo.batch.glyconvert.wurcs.iupac.IupacConvertJobConfig;
import org.glycoinfo.convert.GlyConvert;
import org.glycoinfo.convert.wurcs.WurcsToIupacConverter;
import org.glycoinfo.rdf.InsertSparql;
import org.glycoinfo.rdf.SelectSparql;
import org.glycoinfo.rdf.dao.virt.VirtSesameTransactionConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
		select.setFrom("FROM <http://rdf.glytoucan.org> FROM <http://rdf.glytoucan.org/sequence/wurcs> FROM <https://rdf.glytoucan.org/sequence/iupac_extended>");
		return select;
	}

	@Bean(name = "itemWriterInsertSparql")
	InsertSparql getInsertSparql() {
		ConvertInsertSparql convert = new ConvertInsertSparql();
		convert.setGraphBase(graphbase);
		return convert;
	}
}
