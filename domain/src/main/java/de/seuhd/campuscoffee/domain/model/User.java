package de.seuhd.campuscoffee.domain.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import lombok.Builder;

/**
 * 
 * @param id
 * @param createdAt
 * @param updatedAt
 * @param name
 * @param firstName
 * @param lastName
 * @param emailAddress
 */

@Builder(toBuilder = true)
public record User(
        @Nullable Long id,
        @Nullable LocalDateTime createdAt,
        @Nullable LocalDateTime updatedAt,
        @NonNull String name,
        @NonNull String firstName,
        @NonNull String lastName,
        @NonNull String emailAddress
) implements Serializable { // serializable to allow cloning (see TestFixtures class).
    @Serial
    private static final long serialVersionUID = 1L;
}
