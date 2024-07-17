package com.example.demo.repo;

import com.example.demo.entitiy.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByLogin(String login);
}
