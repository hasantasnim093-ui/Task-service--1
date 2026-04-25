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

part 2 database implementation - https://docs.google.com/document/d/1Bo2wEfQ61OsgUBOfQhWZaOIRWfnKoF2dquKYhFyjPz8/edit?tab=t.0
following screenshots shows successfull endpoints of this task process , it shows the creation (post) throough it being sucessfully creating and being verfied by (GET) which was accessed through the controller. 

The pagination method in the controller shows seperation of process and how it is indicated. 
when tested in postman to get data we do 0 - 5 page which means we collect a portion of the data we want 
instead of collecting the whole data each may be inefficient.




