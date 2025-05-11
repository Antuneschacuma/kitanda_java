package com.donas.kitanda_java.domain.models;

import java.time.Instant;

public class Category {
    private Entity id;
    private final String name;
    private final String description;
    private final Instant createdAt;
    private Instant updatedAt;

    protected Category(CategoryBuilder builder) {
        this.name = builder.getName();
        this.description = builder.getDescription();
        this.createdAt = builder.getCreatedAt() != null ? builder.getCreatedAt() : Instant.now();
        this.updatedAt = builder.getUpdatedAt() != null ? builder.getUpdatedAt() : Instant.now();
    }

    public Entity getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }

    public void setId(Entity id) { this.id = id; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }


    public boolean isNameValid() { return name != null && name.length() >= 2 && name.length() <= 50; }
    public boolean isDescriptionValid() { return description != null && description.length() >= 2 && description.length() <= 500; }

    public void validate() {
        if (!isNameValid()) throw new IllegalStateException("Invalid category name");
        if (!isDescriptionValid()) throw new IllegalStateException("Invalid category description");
    }

    @Override
    public String toString() {
        return String.format("Category:\n" +
                "- Name: %s\n" +
                "- Description: %s\n" +
                "- ID: %s",
                name, description,
                id != null ? id.getValue() : "N/A");
    }
}
