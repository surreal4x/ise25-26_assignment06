package de.seuhd.campuscoffee.data.persistence;

import java.time.LocalDateTime;
import java.time.ZoneId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Database entity for a registered user.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    public static final String LOGIN_NAME_COLUMN = "login_name";
    public static final String LOGIN_NAME_CONSTRAINT = "users_login_name_key";
    public static final String EMAIL_ADDRESS_COLUMN = "email_address";
    public static final String EMAIL_ADDRESS_CONSTRAINT = "users_email_address_key";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence_generator")
    @SequenceGenerator(name = "user_sequence_generator", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = LOGIN_NAME_COLUMN, unique = true)
    private String name;

    @Column(name = EMAIL_ADDRESS_COLUMN, unique = true)
    private String emailAddress;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    /**
     * JPA lifecycle callback: set timestamps before persisting a new entity.
     * This ensures timestamps reflect actual database operation time.
     */
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("UTC"));
        createdAt = now;
        updatedAt = now;
    }

    /**
     * JPA lifecycle callback: update the timestamp before updating an entity.
     * This ensures timestamps reflect actual database operation time.
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now(ZoneId.of("UTC"));
    }
}
