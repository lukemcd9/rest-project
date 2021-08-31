package io.github.lukemcd9.restproject.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.github.lukemcd9.restproject.configuration.RestProjectApplication;
import io.github.lukemcd9.restproject.type.Task;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { RestProjectApplication.class })
public class TaskRepositoryTest {
    
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void findAllTest() {
        List<Task> tasks = taskRepository.findAll();
        assertEquals(1, tasks.size());
        Task task = tasks.get(0);
        //2021-08-15 00:00:01
        LocalDateTime time = LocalDateTime.of(2021, 8, 15, 0, 0, 1);
        assertEquals(1, task.getId());
        assertEquals("Test Task", task.getName());
        assertEquals("A test task to complete", task.getDescription());
        assertEquals(time, task.getCreatedDate());
    } 

    @Test
    public void findById() {
        Task task = taskRepository.getById(1);
        LocalDateTime time = LocalDateTime.of(2021, 8, 15, 0, 0, 1);
        assertEquals(1, task.getId());
        assertEquals("Test Task", task.getName());
        assertEquals("A test task to complete", task.getDescription());
        assertEquals(time, task.getCreatedDate());
    }

}
