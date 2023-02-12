package com.api.ewys;

import com.api.ewys.config.ConfigDataSourcesOnTestcontainers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.lang.NonNull;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * Класс AbstractRestTemplateConfigTest - наследуется всеми остальными тестами с использованием АПИ,
 * создан для удобства и увелечения переиспользования кода
 *
 * @author Max Ivanov
 * created 12.02.2023
 */

@ActiveProfiles(profiles = {"junit"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ConfigDataSourcesOnTestcontainers.class})
public class AbstractRestTemplateConfigTest {

    @Autowired
    public TestRestTemplate restTemplate;

    @NonNull
    public static MultiValueMap<String, String> apiHeaders() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("Content-Type", List.of("application/json"));
        return headers;
    }

}
