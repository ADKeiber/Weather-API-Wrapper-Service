# Weather-Wrapper-Service
Weather Wrapper Service lets users get weather data from an existing 3rd party Weather API. The application utilizes Redis cache to store heavily trafficked data to decrease required third-party API calls. <br>
NOTE: This is part 3 in a multi-part backend project learning experience from https://roadmap.sh/backend/project-ideas 

## Overview
This application is part of a learning experience and is the 3rd project for my backend portfolio. The Weather Wrapper Service is a simple application that allows users to interact with third-party weather APIs. <br>
This particular application's purpose is to demonstrate interaction with third-party APIs and the use of Redis Cache to improve performance. The application is designed in a way that new third-party weather APIs can be added.

Notable things about the application: <br>
Spring Boot <br>
Java 17 <br>
OpenAPI Documentation <br>
third-party API integration <br>
Redis Caching <br>


**REQUIREMENTS TO RUN LOCALLY** <br>
Java 17 installed <br>
Redis installed locally <be>
info.yml file needs to be updated to contain a user's key. For obvious security reasons I used a different file. You could create an account and get your key here. 
https://www.visualcrossing.com/weather-api

Screenshot of Swagger OpenAPI documentation <br>
Can be accessed through http://localhost:8081/swagger-ui/index.html#/ when the application is pulled down and run locally
![image](https://github.com/user-attachments/assets/70a4af3f-98c2-401e-bf9a-650af06db0f2)

Screenshots of Postman test results <br>
Can be accessed in the PostmanTests folder
![image](https://github.com/user-attachments/assets/8f116204-bbd3-4c1b-91bd-addcbe4a9ec2)

