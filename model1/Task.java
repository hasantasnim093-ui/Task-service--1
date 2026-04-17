package edu.brooklyn.cisc3130.taskboard2.model1;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor




public class Task {

private Integer Id;

@NotBlank(message = " Title is required")
@Size(min =3 , max =100, message = "Title must be between 3 and 100 characters")
private String description;
private String title;

private Boolean completed;

private String priority;

public Task(String Title , String description , Boolean completed , String priority){
this.title = title;
this.description = description;
    this.completed = completed != null ? completed : false;
    this.priority = priority != null ? priority : "MEDIUM";








}



}
