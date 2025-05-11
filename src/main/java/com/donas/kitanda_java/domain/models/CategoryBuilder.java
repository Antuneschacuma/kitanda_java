package com.donas.kitanda_java.domain.models;

import java.time.Instant;
import java.util.Objects;

public class CategoryBuilder {
    private String name;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;

    // Getters para acesso às propriedades
    protected String getName() { return name; }
    protected String getDescription() { return description; }
    protected Instant getCreatedAt() { return createdAt; }
    protected Instant getUpdatedAt() { return updatedAt; }

    // Setters com validações
    public CategoryBuilder setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        if (name.length() < 2 || name.length() > 50) {
            throw new IllegalArgumentException("Name must be between 2 and 50 characters");
        }
        return this;
    }

    public CategoryBuilder setDescription(String description) {
        this.description = Objects.requireNonNull(description, "Description cannot be null");
        if (description.length() < 2 || description.length() > 500) {
            throw new IllegalArgumentException("Description must be between 2 and 500 characters");
        }
        return this;
    }

    public CategoryBuilder setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public CategoryBuilder setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Category build() {
        return new Category(this);
    }
}