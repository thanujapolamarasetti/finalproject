package com.mytask.taskmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mytask.taskmanager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
    Optional<User> findById(Long id);

}
