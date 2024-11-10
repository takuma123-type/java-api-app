package com.example.menta_api.interfaces.database;

import com.example.menta_api.domain.userdm.UserEntity;
import com.example.menta_api.domain.userdm.UserRepository;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.concurrent.CompletableFuture;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public CompletableFuture<Void> store(UserEntity user) {
        logger.info("Storing user: {}", user);
        try {
            entityManager.createNativeQuery(
                "INSERT INTO users (id, first_name, last_name, created_at) VALUES (:id, :firstName, :lastName, :createdAt)")
                .setParameter("id", user.getId().toString())
                .setParameter("firstName", user.getFirstName())
                .setParameter("lastName", user.getLastName())
                .setParameter("createdAt", user.getCreatedAt().getValue())
                .executeUpdate();
        } catch (Exception e) {
            logger.error("Failed to store user: {}", e.getMessage());
            throw new RuntimeException("An error occurred while trying to store the user in the database", e);
        }
        return CompletableFuture.completedFuture(null);
    }
    
}
