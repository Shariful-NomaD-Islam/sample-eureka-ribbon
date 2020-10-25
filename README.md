# eureka-ribbon-zipkin
Sample application for load balancing using eureka+ribbon and log tracing using zipkin 

### Requirement

```bash
gradle 6.6+
```


### Build

```bash
git clone https://github.com/Shariful-NomaD-Islam/sample-eureka-ribbon.git
cd sample-eureka-ribbon
gradle clean build
```
### Start tracing-service:

```bash
cd zipkin-server
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar &
cd .. 
```

### Run micro-services:

```bash
gradle :eureka-server:bootRun &
gradle :ribbon-rest:bootRun &

java -jar rest-app/build/libs/eureka-ribbon-rest-app-0.0.1-SNAPSHOT.jar --server.port=9091 &
java -jar rest-app/build/libs/eureka-ribbon-rest-app-0.0.1-SNAPSHOT.jar --server.port=9092 &
java -jar rest-app/build/libs/eureka-ribbon-rest-app-0.0.1-SNAPSHOT.jar --server.port=9093 &
java -jar rest-app/build/libs/eureka-ribbon-rest-app-0.0.1-SNAPSHOT.jar --server.port=9094 &

java -jar rest-app2/build/libs/eureka-ribbon-rest-app2-0.0.1-SNAPSHOT.jar --server.port=9081 &
java -jar rest-app2/build/libs/eureka-ribbon-rest-app2-0.0.1-SNAPSHOT.jar --server.port=9082 &
java -jar rest-app2/build/libs/eureka-ribbon-rest-app2-0.0.1-SNAPSHOT.jar --server.port=9083 &
java -jar rest-app2/build/libs/eureka-ribbon-rest-app2-0.0.1-SNAPSHOT.jar --server.port=9084 &
```

### Test Functionality

```bash
zipkin-server :: http://localhost:9411/zipkin
eureka-server :: http://localhost:8761/  
rest-call-01  :: http://localhost:8081/get-info
rest-call-02  :: http://localhost:8081/get-string
```


###### Created time: 20 OCT 2020
###### Last updated: 25 OCT 2020
