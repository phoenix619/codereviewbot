package com.example.codereviewbot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CodereviewEntity {
    @Id
    private Long id;
    private String title;
    private Boolean completed;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Boolean getCompleted() { return completed; }
    public void setCompleted(Boolean completed) { this.completed = completed; }
}