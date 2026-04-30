package edu.brooklyn.cisc3130.taskboard2.repository;

import edu.brooklyn.cisc3130.taskboard2.model1.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;







public interface TaskRepository extends JpaRepository<Task , Integer>{

    // Find only non-deleted tasks
    List<Task> findByDeletedFalse();

    // Find only deleted tasks
    List<Task> findByDeletedTrue();

    List<Task> findByCompletedTrue();

    List<Task> findByCompletedFalse();

    List<Task> findByPriority(Task.Priority priority);

    List<Task> findByTitleContaining(String title);

    List<Task> findByCompletedAndPriority(Boolean completed , Task.Priority priority);

     @Query("Select t FROM Task t Where t.title LIKE %:keyword% OR t.description LIKE %:keyword%")
List<Task> searchTasks(@Param("keyword") String keyword);


Page<Task> findByCompletedTrue(Pageable pageable);

    long countByPriority(Task.Priority priority);

    @Query("SELECT t FROM Task t WHERE t.deleted = false")
    List<Task> findAllActive();
}
