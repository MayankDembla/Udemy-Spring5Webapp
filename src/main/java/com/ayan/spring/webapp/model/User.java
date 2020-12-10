package com.ayan.spring.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class User {

    private String name;
    private String dept;
    private long salary;
}
