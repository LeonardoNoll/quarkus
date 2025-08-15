package dev.ifrs.leonardo;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;

public class Tarefa {
    private LocalDateTime id;
    private String name;
    private String description;
    
    public Tarefa(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = LocalDateTime.now();
    }
    public Tarefa(){}

    public LocalDateTime getId() {
        return id;
    }

    public void setId(LocalDateTime id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
