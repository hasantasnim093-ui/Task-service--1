package edu.brooklyn.cisc3130.taskboard2.service;

import edu.brooklyn.cisc3130.taskboard2.Exception.TaskNotFoundException;
import edu.brooklyn.cisc3130.taskboard2.model1.Task;
import edu.brooklyn.cisc3130.taskboard2.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional   // rolls back everything if a task is failed to avoid in accurate data processing
public class TaskService {
    private final TaskRepository TR;

@Autowired
public TaskService(TaskRepository Tr){
    this.TR= Tr;
}






    public Task getTaskById(Integer id) {
        return TR.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task updateTask(Integer id, Task updatedTask) {
        Task task = getTaskById(id); // This will throw if not found
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.getCompleted());
        task.setPriority(updatedTask.getPriority());
        return TR.save(task);
    }




    public List<Task> getAllTask() {
return TR.findAll();

}

public Page<Task> getAllTask(Pageable Pg){
return TR.findAll(Pg);
}

public Task createTask(Task task){
    if(task.getCompleted() == null){
        task.setCompleted(false);
    }
    if(task.getPriority() == null){
        task.setPriority(Task.Priority.MEDIUM);
    }

    return TR.save(task);
}

public Optional<Task> GetTaskByID(Integer Id ) {
return TR.findById(Id);

}


public  Optional<Task> updateTask_Optional(Integer id , Task updatedTask) {
    return TR.findById(id).map(task -> {
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.getCompleted());
        task.setPriority(updatedTask.getPriority());
        return TR.save(task);
    });

}


public boolean deleteTask(Integer id) {
   if(TR.existsById(id)){
       TR.deleteById(id);
       return true;
   }
   return false;


}
    public List<Task> getAllTasks() {
        return TR.findByDeletedFalse();
    }
    public void deleteTask2(Integer id) {
        Task task = getTaskById(id);
        task.setDeleted(true);
        TR.save(task);
    }

    public void restoreTask(Integer id) {
        Task task = TR.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        task.setDeleted(false);
        TR.save(task);
    }

    public List<Task> getCompletedTasks() {
        return TR.findByCompletedTrue();
    }

    public List<Task> getIncompleteTasks() {
        return TR.findByCompletedFalse();
    }

    public List<Task> getTasksByPriority(Task.Priority priority) {
        return TR.findByPriority(priority);
    }

    public List<Task> searchTasks(String keyword) {
        return TR.searchTasks(keyword);
    }

    public Page<Task> getCompletedTasks(Pageable pageable) {
        return TR.findByCompletedTrue(pageable);
    }





}













