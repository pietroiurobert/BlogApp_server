package com.example.demo.api.layers.service;

import com.example.demo.api.layers.repository.TestUserRepository;
import com.example.demo.api.model.TestUser;
import com.example.demo.api.model.TestUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TestUserDetailsService implements UserDetailsService {
    private final TestUserRepository testUserRepository;

    @Autowired
    public TestUserDetailsService(TestUserRepository testUserRepository) {
        this.testUserRepository = testUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TestUser testUser = testUserRepository.findByUsername(username);
        if (testUser != null) {
            return new TestUserDetails(testUser);
        } else {
            throw new UsernameNotFoundException("Username not found");
        }
    }
}
