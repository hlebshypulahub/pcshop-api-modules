package com.capgemini.pcshop.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ClientController {

    private final RestTemplate restTemplate;

    public ClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/api/v1/parts")
    public Part getParts(@RequestParam int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        String urlTemplate = UriComponentsBuilder.fromHttpUrl("http://localhost:8090/api/v1/parts")
                                                 .queryParam("id", id)
                                                 .encode()
                                                 .toUriString();

        ResponseEntity<Part> responseEntity = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                Part.class);

        return responseEntity.getBody();
    }

}
