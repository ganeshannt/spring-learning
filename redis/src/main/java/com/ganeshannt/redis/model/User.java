package com.ganeshannt.redis.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * @author Ganeshan Nagarajan
 * @since 25-04-2022
 */

@Data
public class User implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
