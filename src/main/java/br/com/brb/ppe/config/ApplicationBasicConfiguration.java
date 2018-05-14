package br.com.brb.ppe.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@EnableCaching
@ComponentScan({"br.com.brb"})
public class ApplicationBasicConfiguration {

}
