# sample-eureka-ribbon
Sample application for load balancing using eureka and ribbon 

### Build

```bash
git clone https://github.com/Shariful-NomaD-Islam/sample-eureka-ribbon.git
cd sample-eureka-ribbon
gradle clean build
```

### Run micro-services:

```bash
gradle :eureka-server:bootRun &
gradle :ribbon-rest:bootRun &

cd rest-app/build/libs/
java -jar eureka-ribbon-rest-app-0.0.1-SNAPSHOT.jar --server.port=9091 &
java -jar eureka-ribbon-rest-app-0.0.1-SNAPSHOT.jar --server.port=9092 &
java -jar eureka-ribbon-rest-app-0.0.1-SNAPSHOT.jar --server.port=9093 &
java -jar eureka-ribbon-rest-app-0.0.1-SNAPSHOT.jar --server.port=9094 &
```

### Test Functionality

```bash
eureka-server :: http://localhost:8761/  
rest-call     :: http://localhost:8081/get-info
```


###### Created time: 20 OCT 2020
###### Last updated: 20 OCT 2020
