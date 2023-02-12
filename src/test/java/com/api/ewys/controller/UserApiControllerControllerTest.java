package com.api.ewys.controller;

import com.api.ewys.AbstractRestTemplateConfigTest;
import com.api.ewys.models.DemoModel;
import com.api.ewys.models.UserModel;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserApiControllerControllerTest extends AbstractRestTemplateConfigTest {

    @Test
    void getUserInfoList() {
        ResponseEntity<String> rsp = restTemplate.exchange("/api/user/get_all", HttpMethod.GET,
                new HttpEntity<>(apiHeaders()), String.class);
        assertEquals(HttpStatus.OK, rsp.getStatusCode());

        UserModel[] userModels = new Gson().fromJson(rsp.getBody(), UserModel[].class);
        assertNotNull(userModels);

        assertEquals(2, userModels.length);
        assertEquals(0, userModels[0].getId());
        assertEquals("Anton", userModels[0].getFirstname());
        assertEquals("Ivanov", userModels[0].getLastname());
        assertEquals(45, userModels[0].getAge());
        assertEquals("test", userModels[0].getLogin());
        assertEquals("test", userModels[0].getPassword());
    }

    @Test
    void getUserInfoById() {
        ResponseEntity<String> rsp = restTemplate.exchange("/api/user/get/" + 1, HttpMethod.GET,
                new HttpEntity<>(apiHeaders()), String.class);
        assertEquals(HttpStatus.OK, rsp.getStatusCode());

        UserModel userModel = new Gson().fromJson(rsp.getBody(), UserModel.class);
        assertNotNull(userModel);
        assertEquals(1, userModel.getId());
        assertEquals("Zahar", userModel.getFirstname());
        assertEquals("Petrov", userModel.getLastname());
        assertEquals(26, userModel.getAge());
        assertEquals("login", userModel.getLogin());
        assertEquals("password", userModel.getPassword());
    }

    @Test
    void getUserInfoByLogin() {
        ResponseEntity<String> rsp = restTemplate.exchange("/api/user/get/login/" + "login", HttpMethod.GET,
                new HttpEntity<>(apiHeaders()), String.class);
        assertEquals(HttpStatus.OK, rsp.getStatusCode());

        UserModel userModel = new Gson().fromJson(rsp.getBody(), UserModel.class);
        assertNotNull(userModel);

        assertEquals(1, userModel.getId());
        assertEquals("Zahar", userModel.getFirstname());
        assertEquals("Petrov", userModel.getLastname());
        assertEquals(26, userModel.getAge());
        assertEquals("login", userModel.getLogin());
        assertEquals("password", userModel.getPassword());
    }

    @Test
    void insertUserInfo() {
        UserModel card =  new UserModel(3,"1234", "1234", "Elena", "Kovalenko", 70);

        ResponseEntity<String> rsp = restTemplate.exchange("/api/user/insert", HttpMethod.POST,
                new HttpEntity<>(card, apiHeaders()), String.class);
        assertEquals(HttpStatus.OK, rsp.getStatusCode());
    }
}