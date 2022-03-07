package com.javaproject.springboot.design;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @Column(name = "user_role")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    private String name;

    public Integer getId() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer userID) {
        this.userID = userID;
    }

    public UserRole() {
        super();
    }

    public UserRole(Integer userID, String name) {
        super();
        this.userID = userID;
        this.name = name;
    }
}
