package com.Jpa_playground.smy.transaction_demo;

import com.Jpa_playground.smy.user_demo.User;
import com.Jpa_playground.smy.user_demo.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class UserServiceIsolation {

    @Autowired
    private UserRepository userRepository;

    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
}
