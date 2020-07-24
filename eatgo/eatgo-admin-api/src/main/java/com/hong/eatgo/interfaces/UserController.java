package com.hong.eatgo.interfaces;

import com.hong.eatgo.application.UserService;
import com.hong.eatgo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 1. User list
    @GetMapping("/users")
    public List<User> list() {
        List<User> users = userService.getUsers();
        return users;
    }

    // 2. User create -> 회원 가입
    @PostMapping("/users")
    public ResponseEntity<?> create(
            @RequestBody User resource
    ) throws URISyntaxException {
        String email = resource.getEmail();
        String name = resource.getName();
        User user = userService.addUser(email, name);

        String url = "/users/" + user.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }

    // 3. User update
    @PatchMapping("/users/{userId}")
    public String update(
            @PathVariable("userId") Long id,
            @RequestBody User resource
    ) {
        String email = resource.getEmail();
        String name = resource.getName();
        Long level = resource.getLevel();

        userService.updateUser(id,email,name,level);
        return "{}";
    }

    // 4. User delete -> level: 0 => 아무것도 못 함.
    // (1: customer, 2: restaurant owner, 3: admin)
}
