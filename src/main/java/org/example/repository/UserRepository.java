package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
    public User login(String username, String password);

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User findUserByUsername(String username);
}


