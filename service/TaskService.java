package edu.brooklyn.cisc3130.taskboard2.service;

import edu.brooklyn.cisc3130.taskboard2.model1.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service

public class TaskService {
private final List<Task> task = new ArrayList<>();
private final AtomicInteger idGenerator = new AtomicInteger(1);

public List<Task> getAllTask() {
return new ArrayList<>(task);

}

public Optional<Task> GetTaskByID(Integer Id ) {
return task.stream().filter(task -> task.getId().equals(Id)).findFirst();
}

public Task createTask(Task task1) {

    task1.setId(idGenerator.getAndIncrement());

if(task1.getCompleted() == null){
    task1.setCompleted(false);
}
if(task1.getPriority() == null || task1.getPriority().isEmpty() ) {
    task1.setPriority("Medium");
}
task.add(task1);
return task1;



}

public  Optional<Task> updateTask(Integer id , Task updatedTask) {

return GetTaskByID(id).map(task -> {

    task.setTitle(updatedTask.getTitle()); task.setDescription(updatedTask.getDescription());
    task.setCompleted(updatedTask.getCompleted());task.setPriority(updatedTask.getPriority());

return task;
});
}


public boolean deleteTask(Integer id) {
    return task.removeIf(task -> task.getId().equals(id));


}





}













