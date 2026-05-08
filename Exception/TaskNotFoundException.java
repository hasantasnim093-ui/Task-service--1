package edu.brooklyn.cisc3130.taskboard2.Exception;

public class TaskNotFoundException extends RuntimeException{

 public   TaskNotFoundException(Integer id){
     super("Tasks ID: "+ id + " , not found  ");
 }






}
