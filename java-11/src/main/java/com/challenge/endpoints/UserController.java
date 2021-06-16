package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    Optional<User> findById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @GetMapping
    List<User> findByAccelerationNameOrCompanyId(
            @RequestParam(required = false) String accelerationName,
            @RequestParam(required = false) Long companyId
    ) {
        if(accelerationName != null) return userService.findByAccelerationName(accelerationName);
        return userService.findByCompanyId(companyId);
    }
}
