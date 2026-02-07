package com.mytask.taskmanager.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mytask.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
}
