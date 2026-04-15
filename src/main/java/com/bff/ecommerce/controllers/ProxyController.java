package com.bff.ecommerce.controllers;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.bff.ecommerce.dto.CategoryDto;

@RestController
public class ProxyController {
    private final RestClient restClient;

    public ProxyController(final RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> proxyToBackend() {
        return restClient.get()
                .uri("/api/v1/categories")
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<CategoryDto>>() {
                });
    }

}
