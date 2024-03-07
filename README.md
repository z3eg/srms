# srms
Student Result Management System

Developed by Dmytro Cherednyk

## How to run

### Docker

1. Clone repository locally
2. Go into the root directory
3. Execute `docker build -t dc/srms . `. (I have precompiled and pushed the jar to save you some trouble)
4. Execute `docker run -p 8080:8080 dc/srms`
5. Navigate to [localhost:8080](http://localhost:8080) in your browser

### Locally

1. Clone repository locally

#### and either

2. Go into the root directory
3. Run `mvn spring-boot:run`

#### or

2. Import the project into your IDE of choice
3. Run [SrmsApplication.main()](src/main/java/com/dc/srms/SrmsApplication.java)

#### and

4. Navigate to [localhost:8080](http://localhost:8080) in your browser after the up is ready 

