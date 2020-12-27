package com.epam.basics.dao.impl;

import com.epam.basics.dao.UserDao;
import com.epam.basics.entity.User;
import com.epam.basics.warehouse.UserWarehouse;

import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) {
        UserWarehouse.getInstance().add(user);
    }

    @Override
    public boolean containsUsername(String username) {
        boolean contains = UserWarehouse.getInstance().getUser(username).isPresent();
        return contains;
    }

    @Override
    public boolean contains(String username, String password) {
        Optional<User> optionalUser = UserWarehouse.getInstance().getUser(username);
        boolean contains = false;
        if (optionalUser.isPresent()) {
            User foundUser = optionalUser.get();
            contains = foundUser.getPassword().equals(password);
        }
        return contains;
    }

    @Override
    public Optional<User> getUser(String username) {
        Optional<User> optionalUser = UserWarehouse.getInstance().getUser(username);
        return optionalUser;
    }
}
