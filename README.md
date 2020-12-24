# 🔯 S4 Backendportfolio 🔯

This is a personal project I did for Semester 4 on Graduate school Fontys Tilburg.
This is the first time we were required to add CI/CD to our projects. Before this semester we used Jenkins
once. We were only shown an interface and didn't know how to set it up.

We weren't required to use Jenkins. We could have used any other software like github actions. 
In this semester we didn't do much research, because it was already hard to set up a Jenkins configuration.  

## ⚙ Server configuration ⚙

For this project and for this semester I did a lot a configuration on a dedicated server I rented from [Hetzner](https://www.hetzner.com/).
I configured the following:
 * [Nginx reverse proxy](https://www.digitalocean.com/community/tutorials/how-to-configure-nginx-as-a-web-server-and-reverse-proxy-for-apache-on-one-ubuntu-18-04-server)
 * [Sonarqube service for code analysis](https://www.digitalocean.com/community/tutorials/how-to-ensure-code-quality-with-sonarqube-on-ubuntu-18-04)
 * [Tomcat server for deploying](https://www.digitalocean.com/community/tutorials/install-tomcat-9-ubuntu-1804)
 
All the information i mostly found on DigitalOcean. They have wonderful tutorials for explaining what everything does when you enter commands.
The server I was working on was linux based. I had some experience working with linux but not a lot at this moment, so I learned a lot of new commands from doing these tutorials.

//Todo tell something about why it doesn't work at the moment.

### 🐋 Dockerfile & configuration

//Link to the dockerfile.
// Tell something about what people need to do to get it working on their machine.

## 🚧 The project 🚧

The project structure is a simple MVC (model, view, controller) setup. Although the view isn't here because I build a separate front-end for this with [Angular 8](http://www.projectlink.nl).
The front-end was the most focus of this semester. We chose Angular because at first glance this was what most big companies used and because it had a lot of good documentation. 
Also, angular forced you to use a specific structure when creating components, and I liked this kind of strict force, because then you're coding wouldn't get messy.
This was my thought process at the time.

### ⚙ API configuration 
//todo tell something about the API configuration.

### 🧷 CorsFilter
//todo tell something about the CorsFilter

### 🍃 Spring boot 
//todo tell something about Spring Boot and why we used it.

## 🧪 Tests
//todo tell something about tests.
