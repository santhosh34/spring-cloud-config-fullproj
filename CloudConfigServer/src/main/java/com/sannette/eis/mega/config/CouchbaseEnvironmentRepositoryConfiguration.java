package com.sannette.eis.mega.config;

import com.sannette.eis.mega.client.CouchbaseClient;
import com.sannette.eis.mega.repos.CouchbaseEnvironmentRepository;
import com.sannette.eis.mega.repos.CouchbaseEnvironmentRepositoryFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.config.server.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration(proxyBeanMethods = false)
@Import({ CouchbaseRepositoryConfiguration.class})
public class CouchbaseEnvironmentRepositoryConfiguration extends EnvironmentRepositoryConfiguration {

    public CouchbaseEnvironmentRepositoryConfiguration(){
        super();
    }

    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass(CouchbaseClient.class)
    static class CouchbaseFactoryConfig {
        @Bean
        public CouchbaseEnvironmentRepositoryFactory couchbaseEnvironmentRepositoryFactory(
                ConfigServerProperties server) {
            return new CouchbaseEnvironmentRepositoryFactory(server);
        }
    }
}

@Configuration(proxyBeanMethods = false)
@Profile("couchbase")
class CouchbaseRepositoryConfiguration {

    @Bean
    @ConditionalOnMissingBean(CouchbaseEnvironmentRepository.class)
    public CouchbaseEnvironmentRepository couchbaseEnvironmentRepository(
            CouchbaseEnvironmentRepositoryFactory couchbaseEnvironmentRepositoryFactory,
            CouchbaseEnvironmentProperties couchbaseEnvironmentProperties) {
        return couchbaseEnvironmentRepositoryFactory.build(couchbaseEnvironmentProperties);
    }
}