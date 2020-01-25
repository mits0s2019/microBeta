package com.example.authserver.repository;

import com.example.authserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User,Integer> {


    Optional<User> findByUsername(String name);

}