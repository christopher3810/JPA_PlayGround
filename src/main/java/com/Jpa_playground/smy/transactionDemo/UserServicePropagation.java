package com.Jpa_playground.smy.transactionDemo;

import com.Jpa_playground.smy.userDemo.User;
import com.Jpa_playground.smy.userDemo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServicePropagation {

    @Autowired
    private UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
