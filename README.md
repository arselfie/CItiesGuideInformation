Cities Guide Information Telegram bot APIs
-------------------

### Requirements

- Java 11+
- Spring boot 
- Lombok Plugin
- Liquibase
- H2 database

### Build

- Navigate to root directory
- $ mvn clean install

### Run

- Navigate to root directory
- $ java -jar .\target\Cities_Guide_Information-0.0.1-SNAPSHOT.jar

### Swagger RESTful API

- http://{host}:{port}/swagger-ui.html 

### Telegram Bot Settings

- telegram.bot.username=CitiesGuideInformation_bot
- telegram.bot.token=1776535636:AAHmu5uL1VLSWGYp_PyEYkdXCShONwHGlTQ

### Liquibase

- the changelog file contains information about 5 cities by default: Минск, Прага, Москва, Питер, Киев