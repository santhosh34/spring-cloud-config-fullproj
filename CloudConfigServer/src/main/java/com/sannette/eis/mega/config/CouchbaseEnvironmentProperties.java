package com.sannette.eis.mega.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.config.server.support.EnvironmentRepositoryProperties;
import org.springframework.core.Ordered;

@ConfigurationProperties("spring.cloud.config.server.couchbase")
public class CouchbaseEnvironmentProperties implements EnvironmentRepositoryProperties {

    private String connectionString;
    private String userName;
    private String password;
    private String configBucketName;
    private String scope;
    private String collectionName;
    private int order = Ordered.LOWEST_PRECEDENCE;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfigBucketName() {
        return configBucketName;
    }

    public void setConfigBucketName(String configBucketName) {
        this.configBucketName = configBucketName;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public int getOrder() {
        return this.order;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
    }
}
