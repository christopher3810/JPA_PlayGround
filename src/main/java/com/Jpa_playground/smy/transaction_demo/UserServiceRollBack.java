package com.Jpa_playground.smy.transaction_demo;

import com.Jpa_playground.smy.user_demo.User;
import com.Jpa_playground.smy.user_demo.UserRepository;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceRollBack {

    @Autowired
    private UserRepository userRepository;

    @Transactional(rollbackFor = { SQLException.class })
    public void updateUser(User user) throws SQLException {
        userRepository.save(user);
    }

    @Transactional(noRollbackFor = { NullPointerException.class })
    public User getUserById(Long id) throws NullPointerException {
        return userRepository.findById(id)
            .orElseThrow(() -> new NullPointerException("User not found"));
    }
}
