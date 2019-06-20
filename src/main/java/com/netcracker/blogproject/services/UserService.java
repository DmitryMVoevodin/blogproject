package com.netcracker.blogproject.services;

import com.netcracker.blogproject.entities.User;
import com.netcracker.blogproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User enterByLoginAndPassword(String[] userLoginPassword) {
        Iterable<User> allUsers = userRepository.findAll();
        for (User user : allUsers) {
            if (user.getUserLogin().equals(userLoginPassword[0]) &&
                    user.getUserPassword().equals(userLoginPassword[1])) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> users = null;
        users = (List<User>) userRepository.findAll();
        return users;
    }


    public User addUser(User user) {
        if (!userRepository.existsById(user.getUserId())) {
            Iterable<User> allUsers = userRepository.findAll();
            for (User userFromAllUsers : allUsers) {
                if (userFromAllUsers.getUserLogin().equals(user.getUserLogin()) ||
                        userFromAllUsers.getUserNickName().equals(user.getUserNickName())) {
                    return null;
                }
            }
            userRepository.save(user);
            allUsers = userRepository.findAll();
            for (User userFromAllUsers : allUsers) {
                if (userFromAllUsers.getUserLogin().equals(user.getUserLogin())) {
                    return userFromAllUsers;
                }
            }
        } else {
            return null;
        }
        return null;
    }

}
