// src/main/java/com/example/menta_api/domain/shared/CreatedAt.java
package com.example.menta_api.domain.shared;

import java.time.LocalDateTime;

public class CreatedAt {
    private final LocalDateTime timestamp;

    private CreatedAt(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public static CreatedAt newCreatedAt() {
        return new CreatedAt(LocalDateTime.now());
    }

    public LocalDateTime getValue() {
        return timestamp;
    }

    public boolean equals(CreatedAt other) {
        return this.timestamp.equals(other.timestamp);
    }
}
