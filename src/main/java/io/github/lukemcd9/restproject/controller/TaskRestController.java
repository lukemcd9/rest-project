package io.github.lukemcd9.restproject.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.lukemcd9.restproject.service.TaskService;
import io.github.lukemcd9.restproject.type.Task;

@RestController
public class TaskRestController {
    
    private static final Log logger = LogFactory.getLog(TaskRestController.class);

    @Autowired
    private TaskService taskService;

    @GetMapping("/api/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        logger.info("Entered REST Tasks...");
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/task/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Integer id) {
        logger.info("Entered REST Task(" + id + ")...");
        Task task = taskService.findTask(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/api/task")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        logger.info("Created Task(" + task.getId() + ")...");
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.OK);
    }

    @PutMapping("/api/task/{id}")
    public ResponseEntity<Task> editTask(@RequestBody Task task, @PathVariable Integer id) {
        logger.info("Edited Task(" + task.getId() + ")...");
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.OK);
    }

    @DeleteMapping("/api/task/{id}")
    public String deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(taskService.findTask(id));
        logger.info("Deleted Task(" + id + ")...");
        // Redirect after deleting
        return "redirect:/";
    }
}
