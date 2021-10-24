package com.crackbyte.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
}
