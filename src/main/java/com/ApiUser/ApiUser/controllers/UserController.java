package com.ApiUser.ApiUser.controllers;

import com.ApiUser.ApiUser.models.User;
import com.ApiUser.ApiUser.repository.UserRepository;
import com.ApiUser.ApiUser.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User") //EndPoint
public class UserController {

    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    // GET /User
    @GetMapping
    public List<User> userList() {
        return userService.getAllUser();
    }

    // POST /User
    @PostMapping
    public User crateUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // PUT /User/{id}
    @PutMapping("/{id}")
    public User updateUserData(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUserData(id, user);
    }

    // DELETE /User/{id}
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
