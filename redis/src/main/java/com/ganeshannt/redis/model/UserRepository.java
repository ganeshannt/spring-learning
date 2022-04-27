package com.ganeshannt.redis.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ganeshan Nagarajan
 * @since 25-04-2022
 */

@Repository
public class UserRepository {

    private static final String REDIS_KEY = "USER";
    @Autowired
    RedisTemplate redisTemplate;

    public boolean saveUser(User user) {
        try {
            System.out.println(user.toString());
            redisTemplate.opsForHash().put(REDIS_KEY, user.getId(), user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> getAll() {
        return redisTemplate.opsForHash().values(REDIS_KEY);
    }

    public User getUserById(long id) {
        System.out.println("not from cache ... inside user repository");
        User user = (User) redisTemplate.opsForHash().get(REDIS_KEY, id);
        return user;
    }

    public boolean delete(long user_id) {
        try {
            redisTemplate.opsForHash().delete(REDIS_KEY, user_id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User update(long user_id, User user) {
        try {
            redisTemplate.opsForHash().put(REDIS_KEY, user_id, user);
            return getUserById(user_id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
