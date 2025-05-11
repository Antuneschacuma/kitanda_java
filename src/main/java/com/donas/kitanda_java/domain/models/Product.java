package com.donas.kitanda_java.domain.models;

import java.time.Instant;

public class Product {
    private Entity id;
    private final String name;
    private final String brand;
    private final Category category;
    private final String description;
    private double price;
    private int stock;
    private boolean active;
    private final Instant createdAt;
    private Instant updatedAt;

    protected Product(ProductBuilder builder) {
        this.name = builder.getName();
        this.brand = builder.getBrand();
        this.category = builder.getCategory();
        this.description = builder.getDescription();
        this.price = builder.getPrice();
        this.stock = builder.getStock();
        this.active = builder.isActive();
        this.createdAt = builder.getCreatedAt();
        this.updatedAt = builder.getUpdatedAt();
    }

    // Getters
    public Entity getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public Category getCategory() { return category; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public boolean isActive() { return active; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }

    // Setters
    public void setId(Entity id) { this.id = id; }
    public void setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Price must be positive");
        this.price = price;
    }
    public void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("Stock cannot be negative");
        this.stock = stock;
    }
    public void setActive(boolean active) { this.active = active; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

    // Métodos de negócio
    public void increaseStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity to add must be positive");
        }
        this.stock += quantity;
        this.active = true;
    }

    public void decreaseStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity to decrease must be positive");
        }
        if (this.stock < quantity) {
            throw new IllegalStateException("Not enough stock available");
        }
        this.stock -= quantity;
        if (this.stock == 0) {
            this.active = false;
        }
    }

    // Validações
    public boolean isNameValid() { return name != null && name.length() >= 2 && name.length() <= 50; }
    public boolean isBrandValid() { return brand != null && brand.length() >= 2 && brand.length() <= 50; }
    public boolean isDescriptionValid() { return description != null && description.length() >= 2 && description.length() <= 500; }
    public boolean isPriceValid() { return price > 0; }
    public boolean isStockValid() { return stock >= 0; }
    public boolean isCategoryValid() { return category != null; }

    public void validate() {
        if (!isNameValid()) throw new IllegalStateException("Invalid product name");
        if (!isBrandValid()) throw new IllegalStateException("Invalid brand");
        if (!isDescriptionValid()) throw new IllegalStateException("Invalid description");
        if (!isPriceValid()) throw new IllegalStateException("Invalid price");
        if (!isStockValid()) throw new IllegalStateException("Invalid stock");
        if (!isCategoryValid()) throw new IllegalStateException("Invalid category");
    }

    @Override
    public String toString() {
        return String.format("Product:\n" +
                "- Name: %s\n" +
                "- Brand: %s\n" +
                "- Category: %s\n" +
                "- Description: %s\n" +
                "- Price: %.2f\n" +
                "- Stock: %d\n" +
                "- Active: %b\n" +
                "- ID: %s",
                name, brand, category.getName(), description, price, stock, active,
                id != null ? id.getValue() : "N/A");
    }
}

