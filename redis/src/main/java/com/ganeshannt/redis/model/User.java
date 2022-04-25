package com.ganeshannt.redis.model;

import lombok.Data;

/**
 * @author Ganeshan Nagarajan
 * @since 25-04-2022
 */

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String age;
}
