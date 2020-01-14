# DataLog

#### MongoDB Connection
Use the following block in your resource file "application.properties" located in "src/main/resources".

```
# Local MongoDB config
spring.data.mongodb.authentication-database = <mongodb-database-name>
spring.data.mongodb.username = <mongodb-username>
spring.data.mongodb.password = <mongodb-password>
spring.data.mongodb.database = <mongodb-database-name>
spring.data.mongodb.port = <mongodb-server-port>
spring.data.mongodb.host = <mongodb-server-host>

# App config
server.servlet.session.persistent=true
spring.application.name = DataLog
```
