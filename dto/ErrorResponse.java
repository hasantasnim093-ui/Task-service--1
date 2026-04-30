package edu.brooklyn.cisc3130.taskboard2.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ErrorResponse {
private LocalDateTime timeStamp;
private int status;
private String error;
private String message;
private String path;

public ErrorResponse(int status, String error, String message, String path) {

this.timeStamp = LocalDateTime.now();
this.status = status;
this.error = error;
this.message = message;
this.path = path;



}




}
