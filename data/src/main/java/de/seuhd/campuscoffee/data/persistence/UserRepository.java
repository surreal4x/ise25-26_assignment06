package de.seuhd.campuscoffee.data.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

/**
 * Repository for persisting user entities.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>, ResettableSequenceRepository {
    Optional<UserEntity> findByName(String name);

    /**
     * Resets the user ID sequence to start from 1.
     * Note: This is primarily intended for testing purposes to ensure consistent IDs after clearing the table.
     */
    @Override
    @Modifying
    @Transactional
    @Query(value = "ALTER SEQUENCE user_seq RESTART WITH 1", nativeQuery = true)
    void resetSequence();
}
