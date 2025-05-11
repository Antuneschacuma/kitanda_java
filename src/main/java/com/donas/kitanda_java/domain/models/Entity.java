package com.donas.kitanda_java.domain.models;

import java.util.Objects;
import java.util.UUID;

public class Entity {
    private final String value;

    private Entity(String value) {
        this.value = Objects.requireNonNull(value, "ID cannot be null");
    }

    public String getValue() {
        return value;
    }

    public static Entity generate() {
        return new Entity(UUID.randomUUID().toString());
    }

    public static Entity fromString(String id) {
        return new Entity(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity productId = (Entity) o;
        return Objects.equals(value, productId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}