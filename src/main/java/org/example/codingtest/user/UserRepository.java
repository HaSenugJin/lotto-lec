package org.example.codingtest.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.name = :name")
    User findByName(String name);

    @Query("select u from User u where u.id = :id")
    Optional<User> findById(Long id);
}
