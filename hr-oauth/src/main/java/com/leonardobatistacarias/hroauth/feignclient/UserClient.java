package com.leonardobatistacarias.hroauth.feignclient;

import com.leonardobatistacarias.hroauth.feignclient.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserClient {

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email);

}
