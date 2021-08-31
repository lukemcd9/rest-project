package io.github.lukemcd9.restproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.lukemcd9.restproject.type.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findAll();

    Optional<Task> findById(Integer id);

    List<Task> findByCompletedOrderByCompletedDate(Boolean completed);
    
}
