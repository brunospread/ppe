package br.com.brb.ppe.config;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.SimpleJobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBatchConfiguration {

    

    /**
     * Factory que cria um jobRepository para o armazenamento de dados sobre a
     * execucao de jobs em memoria. Nao permite que um job seja reiniciado,
     * utilize o recurso de multi-thread ou particionamento. Para esses cenarios
     * deve ser banco de dados.
     * 
     * @see https://docs.spring.io/spring-batch/trunk/reference/html/
     *      configureJob.html
     * 
     * @param transactionManager
     * @return jobRepository Instancia de MapJobRepository.
     */
    @Bean
    public JobRepository jobRepository(MapJobRepositoryFactoryBean factory) throws Exception {
        return factory.getObject();
    }
    
    @Bean
    public MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean() throws Exception {
        MapJobRepositoryFactoryBean factory = new MapJobRepositoryFactoryBean();
        factory.setTransactionManager(resourcelesstransactionManager());
        factory.afterPropertiesSet();
        return factory;
    }

    @Bean
    public JobLauncher jobLauncher(MapJobRepositoryFactoryBean factory) throws Exception {
        SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
        simpleJobLauncher.setJobRepository(factory.getObject());
        return simpleJobLauncher;
    }
    
    @Bean
    public JobExplorer jobExplorer(MapJobRepositoryFactoryBean factory) {
        return new SimpleJobExplorer(factory.getJobInstanceDao(), factory.getJobExecutionDao(),
                factory.getStepExecutionDao(), factory.getExecutionContextDao());
    }
    
    private ResourcelessTransactionManager resourcelesstransactionManager() {
        return new ResourcelessTransactionManager();
    }
    
}
