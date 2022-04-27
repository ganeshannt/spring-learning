package com.ganeshannt.redis.service;

import com.ganeshannt.redis.model.User;
import com.ganeshannt.redis.model.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(key = "#user_id", value = "USER", unless = "#result.age > 25")
    public User getUserById(long user_id) {
        System.out.println("inside getUserById");
        return userRepository.getUserById(user_id);
    }

    @CacheEvict(key = "#user_id", value = "USER")
    public boolean delete(long user_id) {
        return userRepository.delete(user_id);
    }

    @CachePut(key = "#user_id", value = "USER")
    public User update(long user_id, User user) {
        return userRepository.update(user_id, user);
    }
}
