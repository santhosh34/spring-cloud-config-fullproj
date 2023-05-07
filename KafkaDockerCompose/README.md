
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
    docker exec kafka kafka-topics --bootstrap-server kafka:9092 --create --topic scbsantest1

    Here  1st and 3rd 'kafka' words are container name mentioned in docker-compose file.
    2nd kafka word is kafka command. 

How to list all our topics:

    docker exec kafka kafka-topics --bootstrap-server kafka:29092 --list

How to delete a specific topics:

    docker exec kafka kafka-topics --delete --zookeeper zookeeper:2181 --topic testmyconfigtopic
    docker exec kafka kafka-topics --delete --bootstrap-server kafka:29092 --topic testmyconfigtopic
   

How to Stop All Dockers:

    $pwd
        KafkaDockerCompose
    $docker-compose down 
