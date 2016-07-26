package org.glycoinfo.batch.glyconvert.wurcs.app;

import org.glycoinfo.convert.GlyConvert;
import org.glycoinfo.convert.wurcs.WurcsToIupacCondensedConverter;
import org.glycoinfo.rdf.dao.virt.VirtSesameTransactionConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({VirtSesameTransactionConfig.class})
public class IupacCondensedConvertConfig extends IupacConvertConfig {

	// graph base to set the graph to insert into. The format type (toFormat())
	// will be added to the end.
	public static String graphbase = "http://rdf.glytoucan.org/sequence";

	@Bean(name="org.glycoinfo.batch.glyconvert")
	GlyConvert getGlyConvert() {
		return new WurcsToIupacCondensedConverter();
	}
}