package com.sannette.eis.mega.repos;

import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sannette.eis.mega.config.CouchbaseEnvironmentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.core.Ordered;

import java.util.Map;

public class CouchbaseEnvironmentRepository implements EnvironmentRepository, Ordered {

    private final Collection couchbaseCollection;
    private int order;

    @Autowired
    private ObjectMapper objectMapper;

    public CouchbaseEnvironmentRepository(Collection couchbaseCollection,
                                          CouchbaseEnvironmentProperties couchbaseEnvironmentProperties) {
        this.couchbaseCollection = couchbaseCollection;
        this.order = couchbaseEnvironmentProperties.getOrder();
    }

    @Override
    public Environment findOne(String application, String profile, String label) {

        Environment environment = new Environment(application, profile, label, null, null);
        GetResult getResult = couchbaseCollection.get(application);
        environment.add(new PropertySource("couchbase:" + application, getResultMap(getResult)));
        return environment;
    }


    public Map<String, Object>  getResultMap(GetResult getResult){
        return  objectMapper.convertValue(getResult.contentAs(JsonNode.class),
                new TypeReference<Map<String, Object>>() {
                });
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}