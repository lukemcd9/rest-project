package io.github.lukemcd9.restproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.lukemcd9.restproject.repository.TaskRepository;
import io.github.lukemcd9.restproject.type.Task;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findTask(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task saveTask(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
        taskRepository.flush();
    }
}
