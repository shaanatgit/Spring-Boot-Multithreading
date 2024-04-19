package com.demo.multithreading.executor.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_TBL")
public class User {

    @Id
    @GeneratedValue
    private int Id;
    private String name;
    private String email;
    private String gender;


}
