package com.epam.basics.dao;

import com.epam.basics.entity.User;

import java.util.Optional;

public interface UserDao {
    void addUser(User user);

    boolean containsUsername(String username);

    boolean contains(String username, String password);

    Optional<User> getUser(String username);
}
