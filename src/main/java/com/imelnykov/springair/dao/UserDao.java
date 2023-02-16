package com.imelnykov.springair.dao;

import com.imelnykov.springair.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query("""
        SELECT u FROM User u
        JOIN u.contactId c
        WHERE c.email = :email
        """)
    Optional<User> findByEmail(String email);
}
