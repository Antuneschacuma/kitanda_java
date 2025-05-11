package com.donas.kitanda_java.domain.models;

import java.time.Instant;
import java.util.Objects;

public class ProductBuilder {
    private String name;
    private String brand;
    private Category category;
    private String description;
    private double price;
    private int stock;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;

    public ProductBuilder() {
        this.stock = 0;
        this.active = true;
    }

    protected String getName() { return name; }
    protected String getBrand() { return brand; }
    protected Category getCategory() { return category; }
    protected String getDescription() { return description; }
    protected double getPrice() { return price; }
    protected int getStock() { return stock; }
    protected boolean isActive() { return active; }
    protected Instant getCreatedAt() { return createdAt; }
    protected Instant getUpdatedAt() { return updatedAt; }

    public ProductBuilder setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        return this;
    }

    public ProductBuilder setBrand(String brand) {
        this.brand = Objects.requireNonNull(brand, "Brand cannot be null");
        return this;
    }

    public ProductBuilder setCategory(Category category) {
        this.category = Objects.requireNonNull(category, "Category cannot be null");
        return this;
    }

    public ProductBuilder setDescription(String description) {
        this.description = Objects.requireNonNull(description, "Description cannot be null");
        return this;
    }

    public ProductBuilder setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Price must be positive");
        this.price = price;
        return this;
    }

    public ProductBuilder setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("Stock cannot be negative");
        this.stock = stock;
        return this;
    }

    public ProductBuilder setActive(boolean active) {
        this.active = active;
        return this;
    }

    public ProductBuilder setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ProductBuilder setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Product build() {
        return new Product(this);
    }
}

// Category.java
