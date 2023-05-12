package com.sannette.eis.mega.repos;

import com.couchbase.client.java.Collection;
import com.sannette.eis.mega.client.CouchbaseClient;
import com.sannette.eis.mega.config.CouchbaseEnvironmentProperties;
import org.springframework.cloud.config.server.config.ConfigServerProperties;

import org.springframework.cloud.config.server.environment.EnvironmentRepositoryFactory;

public class CouchbaseEnvironmentRepositoryFactory implements EnvironmentRepositoryFactory<CouchbaseEnvironmentRepository,
        CouchbaseEnvironmentProperties> {
    private ConfigServerProperties configServerProperties;
    public CouchbaseEnvironmentRepositoryFactory(ConfigServerProperties configServerProperties){
        this.configServerProperties = configServerProperties;
    }
    @Override
    public CouchbaseEnvironmentRepository build(CouchbaseEnvironmentProperties environmentProperties) {

        final Collection  collection = new CouchbaseClient().build(environmentProperties);
        CouchbaseEnvironmentRepository repository =
                new CouchbaseEnvironmentRepository(collection, environmentProperties);
        repository.setOrder(environmentProperties.getOrder());
        return repository;
    }

}