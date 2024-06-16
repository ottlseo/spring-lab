package org.example.domain.repository;

import org.example.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
//    Optional<User> findById(String userId); // already declared in JpaRepository
    Optional<User> findByUserName(String userName);

//    List<User> findAll(); // already declared in JpaRepository
//    User save(User user); // already declared in JpaRepository
}
