package io.github.lukemcd9.restproject.type;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="task")
public class Task {
    
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Getter
    @Setter
    @Column(name="name")
    private String name;

    @Getter
    @Setter
    @Column(name="description")
    private String description;

    @Getter
    @Setter
    @Column(name="createdDate")
    private LocalDateTime createdDate;

    @Getter
    @Setter
    @Column(name="completedDate")
    private LocalDateTime completedDate;

    @Getter
    @Setter
    @Column(name="completed")
    private Boolean completed;
}
