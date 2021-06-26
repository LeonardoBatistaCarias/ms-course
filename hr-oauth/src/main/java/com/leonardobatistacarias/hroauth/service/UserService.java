package com.leonardobatistacarias.hroauth.service;

import com.leonardobatistacarias.hroauth.feignclient.UserClient;
import com.leonardobatistacarias.hroauth.feignclient.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserClient userClient;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public User findByEmail(String email) {
        var user = userClient.findByEmail(email).getBody();

        if(user == null) {
            logger.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found: " + email);
        return user;
    }

}
