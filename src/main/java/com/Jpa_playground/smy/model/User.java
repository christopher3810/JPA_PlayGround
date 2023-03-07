package com.Jpa_playground.smy.model;

import io.hypersistence.tsid.TSID;
import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.function.Supplier;
@Entity(name="UserInfo")
@Table(name="userInfo")
public class User {

    public static class CustomTsidSupplier implements Supplier<TSID.Factory>{
        @Override
        public TSID.Factory get(){
            return TSID.Factory.builder().withNodeBits(1).build();
        }
    }

    @Id
    @Tsid(CustomTsidSupplier.class) //Tsid test
    private long id;
}
