
Step1: 
    Config Server On:               localhost:8888
    Config Repo:            https://github.com/santhosh34/spring-cloud-config-store.git

    Server Validation: 
    Url to check: http://localhost:8888/notification-service/stg

Step2: 
Product Register On:            localhost:8081
        This will fail to fetch if no search string in server config params

    search-paths:
        - '{application}{profile}'

Step3: 
Notification Server On:         localhost:8082

