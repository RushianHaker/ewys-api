package com.api.ewys.controller;

import com.api.ewys.AbstractRestTemplateConfigTest;
import com.api.ewys.models.DemoModel;
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

public class DemoApiControllerControllerTest extends AbstractRestTemplateConfigTest {

    @Test
    void getDemoInfoList() {
        ResponseEntity<String> rsp = restTemplate.exchange("/api/demo/get_all", HttpMethod.GET,
                new HttpEntity<>(apiHeaders()), String.class);
        assertEquals(HttpStatus.OK, rsp.getStatusCode());

        DemoModel[] demoModels = new Gson().fromJson(rsp.getBody(), DemoModel[].class);
        assertNotNull(demoModels);

        assertEquals(6, demoModels.length);
        assertEquals(0, demoModels[0].getId());
        assertEquals("Mark", demoModels[0].getName());
        assertEquals("Vasquez", demoModels[0].getFullName());
    }

    @Test
    void getDemoInfoById() {
        ResponseEntity<String> rsp = restTemplate.exchange("/api/demo/get/" + 1, HttpMethod.GET,
                new HttpEntity<>(apiHeaders()), String.class);
        assertEquals(HttpStatus.OK, rsp.getStatusCode());

        DemoModel demoModel = new Gson().fromJson(rsp.getBody(), DemoModel.class);
        assertNotNull(demoModel);

        assertEquals(1, demoModel.getId());
        assertEquals("Anna", demoModel.getName());
        assertEquals("Ivanov", demoModel.getFullName());
    }

    @Test
    void getDemoInfoListByNames() {
        String name1 = "Mark";
        String name2 = "Anne";

        URI forCheck = UriComponentsBuilder
                .fromUriString("/api/demo/get_names")
                .queryParam("names", name1, name2)
                .build()
                .encode()
                .toUri();

        ResponseEntity<String> rsp = restTemplate.exchange(forCheck.toString(), HttpMethod.GET,
                new HttpEntity<>(apiHeaders()), String.class);
        assertEquals(HttpStatus.OK, rsp.getStatusCode());

        DemoModel[] demoModels = new Gson().fromJson(rsp.getBody(), DemoModel[].class);
        assertNotNull(demoModels);

        assertEquals(1, demoModels.length);
        assertEquals(0, demoModels[0].getId());
        assertEquals("Mark", demoModels[0].getName());
        assertEquals("Vasquez", demoModels[0].getFullName());
    }

    @Test
    void insertDemoInfoList() {
        List<DemoModel> cards = new ArrayList<>();
        cards.add(new DemoModel(3, "Andrea", "Jonatoniano"));
        cards.add(new DemoModel(4, "Max", "Ibragioml"));
        cards.add(new DemoModel(5, "Alexander", "Isakov"));

        ResponseEntity<String> rsp = restTemplate.exchange("/api/demo/insert", HttpMethod.POST,
                new HttpEntity<>(cards, apiHeaders()), String.class);
        assertEquals(HttpStatus.OK, rsp.getStatusCode());
    }
}