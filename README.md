# Task-service--1
A Task Service with integrated Spring boot framework


The Campus Task Board API is a Spring Boot backend application that allows users to manage tasks through a RESTful API. Users can create, view, update, and delete tasks. Each task contains a title, description, completion status, and priority level.

This project demonstrates core backend development concepts including:
- REST API design using Spring Boot
- HTTP methods (GET, POST, PUT, DELETE)
- Controller-Service architecture
- Input validation using Spring Validation
- JSON request/response handling
- Use of Lombok to reduce boilerplate code
- Proper project structure following industry standards

The API does not include a frontend and is intended to be tested using Postman or integrated with a frontend application.

---

how to run the application 
1- through interacting with the frontend UI which will generate a output 
2- through using POSTMAN, that helps us test, we can provide an input through testing the 
GET POST PUT DELETE 
which will be accessed through the controller , which will then be directed to the service in order to access the set feature 

visual example 
client(us) -> controller -> service -> GET POST PUT DELETE -> controller - client 

testing endpoints - https://docs.google.com/document/d/1-CZi1mJjS165YYIMGne_8QwETA8jEcSwrS901HXg10c/edit?tab=t.0 
GET (ID) - WHEN ACCESSED WITH A ID , IN THIS METHOD  1 CAN BE inputed , IF IT EXIST IT WILL PRODVIDE 200 OK(exist) 
else if a false Id is entered (non existent ID) it will show an output of [404 not found] 
PUT (ID) - to update , it will provide 200 ok, meaning successfully ubdated 
Post(ID) - a new task being created with a designated ID number being provided if successfull [201 created] is showen 
Deleted -  a feature that will delete , after deleted [204 no content] showen t0 confirm it is deleted 

video guide to the project - https://drive.google.com/file/d/1emWxx1gTRm4Wbvm4qhR9kHdqZpf3HK73/view?usp=sharing

part 2 database implementation(hw6) - https://docs.google.com/document/d/1Bo2wEfQ61OsgUBOfQhWZaOIRWfnKoF2dquKYhFyjPz8/edit?tab=t.0
following screenshots shows successfull endpoints of this task process , it shows the creation (post) throough it being sucessfully creating and being verfied by (GET) which was accessed through the controller. 

The pagination method in the controller shows seperation of process and how it is indicated. 
when tested in postman to get data we do 0 - 5 page which means we collect a portion of the data we want 
instead of collecting the whole data each may be inefficient.

video guide to data implementation - https://drive.google.com/file/d/18np-d3nyxI1q1HdZw2TsQyMSVhII9cV6/view?usp=sharing


part 3 

Error resposnse screenshots - https://docs.google.com/document/d/1SV_dW1JZOwCJTfrDzikUEweH2A_uf_W_OSIH6zxONCM/edit?usp=sharing  

Exception handling integrated into this project creates a safe barrier that allows for the whole project to not crash

Creating a system, when a incorrect process was entered by the user, the exception handler catches the error and responds with a error message , rather then the whole project crashing 

Creating DTOs, 

DTO - Data transfer object 
its acts as a layer of safety in how our backend recives and provides data to the user

integrating this allows as a layer of protection from mis-use from user end 
As user could enter an invalid response to our System which allows for crash 

This is where DTOs come in which provides limited user task request that would allow zero - minimal errors 


video guide to Exception handling and DTOs in this project - https://drive.google.com/file/d/1daq4wVOIXMLPH0ry8g1kaHk7lOU9AD1c/view?usp=sharing

part -4

Successfull end point test - https://docs.google.com/document/d/1V-thaHgqz4jpmoBc7lhF_0cZgE8x_lZhn2pFDAiJaMc/edit?usp=sharing


The security aspect of this project

Currently our backend system allows our product to be accessed without any credentials or process

In defination anyone in the internet could Access our product which creates vulnerability to our system.

This is where Spring secuirty comes in, it allows proper access to the individual that is credible and verfied to call our backend system

How this Security feature was implemented?
 
Allowing credible frontend ( 3030 ) services to call this backend system 

Endpoints - Only allowing specific endpoints to be processed 

which means it was configuered in a way where some endpoints are public(accesible) and private 


video guide - https://drive.google.com/file/d/1p2q2pAdzNCD49JRnxhwrR1gDweUAYLBR/view?usp=sharing









