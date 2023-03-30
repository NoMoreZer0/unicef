# nis_unicef-main-v2

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Location of the end project](#location-of-the-end-project)
* [Setup](#setup)
* [API](#api)

## General info
This project is for NIS UNICEF case generator
	
## Technologies
Project is created with:
* Java version: 17
* Spring Boot version: 2.9
* Docker for containerization and subsequent upload to hosting
* React for front-end

## Location of the end project
The project currently is being hosted at Kazakhstani server. It can be accessed it by the adress: pdpcm.kz. Moreover, the backup of the project is hosted at Digital Ocean platform, and can be accessed via address 137.184.5.147. For entering the server terminal simply type ```ssh root@137.184.5.147```, and when the password is prompted, type ```3ve&uNq9N?g78Gw```.
	
## Setup
To run this project, install it locally, and run the server part using mvn:

```
$ mvn spring-boot:run
```
Then run the client part using npm:
```
$ npm i
$ npm start
```

* Alternative way to run the project exists, which is connecting to the DigitalOcean server mentioned above. The Docker container is already running there, but you can run it repeatedly by typing `docker compose --build up`.


## API
To get all the endpoints used in the project, go directly to the https://pdpcm.kz/api/swagger-ui/index.html#/
