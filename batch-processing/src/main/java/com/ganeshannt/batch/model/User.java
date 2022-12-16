package com.ganeshannt.batch.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    private Integer id;
    private String name;
    private String department;
    private Integer salary;
}
