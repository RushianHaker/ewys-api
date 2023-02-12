package com.api.ewys.controllers;

import com.api.ewys.models.UserModel;
import com.api.ewys.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserApiController {
    public final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/get_all")
    public List<UserModel> getUserInfoList() {
        return userService.getUserInfoList();
    }

    @GetMapping("/user/get/{id}")
    public UserModel getUserInfoListById(@NotNull @PathVariable(name = "id") Long id) {
        return userService.getUserInfoById(id);
    }

    @GetMapping("/user/get/login/{login}")
    public UserModel getUserInfoListByLogin(@NotNull @PathVariable(name = "login") String login) {
        return userService.getUserInfoByLogin(login);
    }

    @PostMapping("/user/insert")
    public void saveUserInfo(@NotNull @RequestBody UserModel model) {
        userService.saveUserInfo(model);
    }
}
