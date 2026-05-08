package edu.brooklyn.cisc3130.taskboard2.controller;

import edu.brooklyn.cisc3130.taskboard2.dto.TaskRequest;
import edu.brooklyn.cisc3130.taskboard2.dto.TaskResponse;
import edu.brooklyn.cisc3130.taskboard2.model1.Task;
import edu.brooklyn.cisc3130.taskboard2.service.TaskService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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


    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getCompletedTasks() {
        List<Task> tasks = TS.getCompletedTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/incomplete")
    public ResponseEntity<List<Task>> getIncompleteTasks() {
        List<Task> tasks = TS.getIncompleteTasks();
        return ResponseEntity.ok(tasks);
    }


    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Task>> getTasksByPriority(
            @PathVariable String priority) {
        try {
            Task.Priority priorityEnum = Task.Priority.valueOf(priority.toUpperCase());
            List<Task> tasks = TS.getTasksByPriority(priorityEnum);
            return ResponseEntity.ok(tasks);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTasks(@RequestParam String keyword) {
        List<Task> tasks = TS.searchTasks(keyword);
        return ResponseEntity.ok(tasks);
    }






 @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
List<Task> tasks = TS.getAllTask();
return ResponseEntity.ok(tasks);
 }

 @GetMapping("/id/{id}")
    public ResponseEntity<Task> getTaskById (@PathVariable Integer id){
        Optional<Task> task = TS.GetTaskByID(id);

        return task.map(ResponseEntity:: ok).orElse(ResponseEntity.notFound().build());
 }

 @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task){
        Task createdTask = TS.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
 }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(
            @Valid @RequestBody TaskRequest taskRequest) {
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setCompleted(taskRequest.getCompleted() != null ? taskRequest.getCompleted() : false);
        task.setPriority(Task.Priority.valueOf(
                taskRequest.getPriority() != null ?
                        taskRequest.getPriority().toUpperCase() : "MEDIUM"));

        Task createdTask = TS.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TaskResponse.fromEntity(createdTask));
    }







    @PutMapping ("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id , @Valid @RequestBody Task task){

Optional<Task> updatedTask = TS.updateTask_Optional(id, task);
return updatedTask.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }
    @GetMapping("/paginated")
    public ResponseEntity<Page<Task>> getTasksPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Task> tasks = TS.getAllTask(pageable);
        return ResponseEntity.ok(tasks);
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
