package com.ganeshannt.activemq;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MyMessage implements Serializable {
    private String message;
}
