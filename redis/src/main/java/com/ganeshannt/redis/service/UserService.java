package com.ganeshannt.redis.service;

import com.ganeshannt.redis.model.User;
import com.ganeshannt.redis.model.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ganeshan Nagarajan
 * @since 25-04-2022
 */

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

    public boolean delete(long user_id) {
        return userRepository.delete(user_id);
    }

    public boolean update(long user_id, User user) {
        return userRepository.update(user_id, user);
    }
}
