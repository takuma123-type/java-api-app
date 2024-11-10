package com.example.menta_api.domain.shared;

import java.time.LocalDateTime;
import java.util.Objects;

public class UpdatedAt {
    private final LocalDateTime value;

    public UpdatedAt() {
        this.value = LocalDateTime.now();
    }

    public UpdatedAt(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime getValue() {
        return value;
    }

    public boolean equals(UpdatedAt other) {
        return this.value.isEqual(other.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdatedAt updatedAt = (UpdatedAt) o;
        return value.isEqual(updatedAt.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
