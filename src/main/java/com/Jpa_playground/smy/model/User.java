package com.Jpa_playground.smy.model;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="UserInfo")
@Table(name="userInfo")
public class User {

    @Id
    @Tsid
    private long id;
}
