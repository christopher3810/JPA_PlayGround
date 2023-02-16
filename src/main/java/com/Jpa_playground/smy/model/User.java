package com.jpa_playground.smy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="UserInfo")
@Table(name="userInfo")
public class User {

    @Id
    private long id;
}
