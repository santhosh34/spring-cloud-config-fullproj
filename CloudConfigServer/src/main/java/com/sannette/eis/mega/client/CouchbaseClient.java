package com.sannette.eis.mega.client;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.sannette.eis.mega.config.CouchbaseEnvironmentProperties;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CouchbaseClient {

    public Collection build(CouchbaseEnvironmentProperties couchbaseEnvironmentProperties){
        return Cluster.connect(
                        couchbaseEnvironmentProperties.getConnectionString(),
                        couchbaseEnvironmentProperties.getUserName(),
                        couchbaseEnvironmentProperties.getPassword())
                .bucket(couchbaseEnvironmentProperties.getConfigBucketName())
                .scope(couchbaseEnvironmentProperties.getScope())
                .collection(couchbaseEnvironmentProperties.getCollectionName());
    }

}