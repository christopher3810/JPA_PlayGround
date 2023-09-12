package com.Jpa_playground.smy.user_demo;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="UserInfo")
@Table(name="userInfo")
@NoArgsConstructor
@Getter
public class User {

    @Id @Tsid
    private Long id;

    private String name;


    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}
