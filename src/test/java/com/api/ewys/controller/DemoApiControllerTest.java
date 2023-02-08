package com.api.ewys.controller;

import com.api.ewys.config.ConfigDataSourcesOnTestcontainers;
import com.api.ewys.models.DemoModel;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles(profiles = {"junit"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ConfigDataSourcesOnTestcontainers.class})
public class DemoApiControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @NonNull
    public static MultiValueMap<String, String> apiHeaders() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("Content-Type", List.of("application/json"));
        return headers;
    }

    @Test
    void getDemoInfoList() {
        String name1 = "Mark";
        String name2 = "Anne";

        URI forCheck = UriComponentsBuilder
                .fromUriString("/api/demo/get")
                .queryParam("names", name1, name2)
                .build()
                .encode()
                .toUri();

        ResponseEntity<String> rsp = restTemplate.exchange(forCheck.toString(), HttpMethod.GET,
                new HttpEntity<>(apiHeaders()), String.class);
        assertEquals(HttpStatus.OK, rsp.getStatusCode());

        DemoModel[] demoModels = new Gson().fromJson(rsp.getBody(), DemoModel[].class);

        assertNotNull(demoModels);
        assertNotNull(demoModels[0].getName());
        assertEquals(1, demoModels.length);

        assertEquals(0, demoModels[0].getId());
        assertEquals("Mark", demoModels[0].getName());
        assertEquals("Vasquez", demoModels[0].getFullName());
    }

    @Test
    void insertDemoInfoList() {
        List<DemoModel> cards = new ArrayList<>();
        cards.add(new DemoModel(0, "Andrea", "Jonatoniano"));
        cards.add(new DemoModel(1, "Max", "Ibragioml"));
        cards.add(new DemoModel(2, "Alexander", "Isakov"));

        ResponseEntity<String> rsp = restTemplate.exchange("/api/demo/insert", HttpMethod.POST,
                new HttpEntity<>(cards, apiHeaders()), String.class);
        assertEquals(HttpStatus.OK, rsp.getStatusCode());
    }
}