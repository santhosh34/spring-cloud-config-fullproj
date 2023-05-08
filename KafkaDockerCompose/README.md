
<h2>Instructions to Start the Kafka Docker and ZooKeeper in Mac Pro M1</h2>

How to start:

    $ cd KafkaDockerCompose
    $pwd:
        KafkaDockerCompose
    $docker-compose up -d

Now let's use the nc command to verify that both the servers are listening on the respective ports:

    $ nc -z localhost 22181
    Connection to localhost port 22181 [tcp/*] succeeded!

    $ nc -z localhost 29092
    Connection to localhost port 29092 [tcp/*] succeeded!

    $ docker-compose logs kafka | grep -i started
    kafka_1      | [2021-04-10 22:57:40,413] DEBUG [ReplicaStateMachine controllerId=1] Started replica state machine with initial state -> HashMap() (kafka.controller.ZkReplicaStateMachine)
    kafka_1      | [2021-04-10 22:57:40,418] DEBUG [PartitionStateMachine controllerId=1] Started partition state machine with initial state -> HashMap() (kafka.controller.ZkPartitionStateMachine)
    kafka_1      | [2021-04-10 22:57:40,447] INFO [SocketServer brokerId=1] Started data-plane acceptor and processor(s) for endpoint : ListenerName(PLAINTEXT) (kafka.network.SocketServer)
    kafka_1      | [2021-04-10 22:57:40,448] INFO [SocketServer brokerId=1] Started socket server acceptors and processors (kafka.network.SocketServer)
    kafka_1      | [2021-04-10 22:57:40,458] INFO [KafkaServer id=1] started (kafka.server.KafkaServer)


Developer Draft Notes:
----------------------

Currently, We are using this docker compose file( Kafka and Zookeeper) to be used by Spring cloud config setup

Spring Cloud Config Project: 

Learning how to connect to Kafka Broker running inside docker

Create a new topic in container: 
    docker exec kafka kafka-topics --bootstrap-server kafka:9092 --create --topic myownmanuallycreatedtopic

    Here  1st and 3rd 'kafka' words are container name mentioned in docker-compose file.
    2nd kafka word is kafka command. 

How to list all our topics:

    docker exec kafka kafka-topics --bootstrap-server kafka:29092 --list

How to delete a specific topics:

    docker exec kafka kafka-topics --delete --zookeeper zookeeper:2181 --topic myownmanuallycreatedtopic
    docker exec kafka kafka-topics --delete --bootstrap-server kafka:29092 --topic myownmanuallycreatedtopic
   

How to Stop All Dockers:

    $pwd
        KafkaDockerCompose
    $docker-compose down 

Vault: 
----------------------------
docker exec vault vault status                            
Key             Value
---             -----
Seal Type       shamir
Initialized     true
Sealed          false
Total Shares    1
Threshold       1
Version         1.13.2
Build Date      2023-04-25T13:02:50Z
Storage Type    file
Cluster Name    vault-cluster-28200ac2
Cluster ID      d60c79f6-c509-c569-197d-abc8ea841fc0
HA Enabled      false

docker exec -it vault  vault  login   
Token (will be hidden): <<Give the Token>>

docker exec vault  vault kv put secret/myapp key1=value1
docker exec vault  vault kv put secret/myapp key1=value1 -token="hvs.CPNeSjNXR1VOKWNvpRv7i6iV"
docker exec vault  vault kv get producer-application
docker exec vault  vault kv get secret/producer-application

-----Diff flow
docker-compose up -d 
docker ps
docker-compose exec vault sh
$vault operator init
    Error initializing: Error making API request.
    URL: PUT http://127.0.0.1:8200/v1/sys/init
    Code: 400. Errors:
    * Vault is already initialized
$vault operator unseal 102aceeb9ccc7a3e2d446b1249e28fa21d1c2777283720b7dde76556cc68c143

    Key             Value
    ---             -----
    Seal Type       shamir
    Initialized     true
    Sealed          false
    Total Shares    1
    Threshold       1
    Version         1.13.2
    Build Date      2023-04-25T13:02:50Z
    Storage Type    file
    Cluster Name    vault-cluster-28200ac2
    Cluster ID      d60c79f6-c509-c569-197d-abc8ea841fc0
    HA Enabled      false

$ vault login hvs.CPNeSjNXR1VOKWNvpRv7i6iV

    Success! You are now authenticated. The token information displayed below
    is already stored in the token helper. You do NOT need to run "vault login"
    again. Future Vault requests will automatically use this token.

    Key                  Value
    ---                  -----
    token                hvs.CPNeSjNXR1VOKWNvpRv7i6iV
    token_accessor       FEwGhBklUtJqxD5iAOak7q70
    token_duration       ∞
    token_renewable      false
    token_policies       ["root"]
    identity_policies    []
    policies             ["root"]

$ vault kv get kv/producer-application

    ======== Secret Path ========
    kv/data/producer-application

    ======= Metadata =======
    Key                Value
    ---                -----
    created_time       2023-05-08T01:09:12.111771802Z
    custom_metadata    <nil>
    deletion_time      n/a
    destroyed          false
    version            1

    ==== Data ====
    Key     Value
    ---     -----
    key1    secretvalue1
    key2    secretvalue2

$ 

Lets say if you are accessing from HOST

curl -vik -H "X-Vault-Token: hvs.CPNeSjNXR1VOKWNvpRv7i6iV" http://localhost:8200/v1/cubbyhole/mytestkey
