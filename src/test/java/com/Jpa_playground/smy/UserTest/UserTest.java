package com.Jpa_playground.smy.UserTest;

import static org.junit.jupiter.api.Assertions.*;

import com.Jpa_playground.smy.model.User;
import com.Jpa_playground.smy.model.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
@Rollback(false)
class UserTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    @Test
    public void testCreateUser() {
        em.persist(
            new User()
                .setName("Persistencer")
        );
        em.flush();

        List<User> users = em.createQuery("select m from UserInfo m", User.class)
            .getResultList();

        for (User userList : users) {
            System.out.println("user = " + userList);
            System.out.println("-> user tsid = " + userList.getId());
        }
    }

}