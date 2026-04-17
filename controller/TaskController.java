package edu.brooklyn.cisc3130.taskboard2.controller;

import edu.brooklyn.cisc3130.taskboard2.model1.Task;
import edu.brooklyn.cisc3130.taskboard2.service.TaskService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")









public class TaskController {
private final TaskService TS;


    public TaskController(TaskService ts) {
        TS = ts;
    }
 @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
List<Task> tasks = TS.getAllTask();
return ResponseEntity.ok(tasks);
 }

 @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById (@PathVariable Integer id){
        Optional<Task> task = TS.GetTaskByID(id);

        return task.map(ResponseEntity:: ok).orElse(ResponseEntity.notFound().build());
 }

 @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task){
        Task createdTask = TS.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
 }

    @PostMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id , @Valid @RequestBody Task task){

Optional<Task> updatedTask = TS.updateTask(id, task);
return updatedTask.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }


    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteTask(@PathVariable Integer id){
        boolean deleted = TS.deleteTask(id);
        return deleted ? ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
Map<String, String> errors = new HashMap<>();
ex.getBindingResult().getAllErrors().forEach(error -> {

    String fieldName= ((FieldError) error).getField();
    String errorMessage = error.getDefaultMessage();
    errors.put(fieldName, errorMessage);




});
return errors;



    }
    
}
