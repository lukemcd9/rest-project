package io.github.lukemcd9.restproject.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void accessors() {
        Task task = new Task();
        task.setId(9999);
        task.setName("Test Task");
        task.setDescription("test");
        task.setCompleted(false);
        LocalDateTime now = LocalDateTime.now();
        task.setCreatedDate(now);

        assertEquals(task.getId(), 9999);
        assertEquals(task.getName(), "Test Task");
        assertEquals(task.getCompleted(), false);
        assertNull(task.getCompletedDate());
        assertEquals(task.getCreatedDate(), now);
    }

}
