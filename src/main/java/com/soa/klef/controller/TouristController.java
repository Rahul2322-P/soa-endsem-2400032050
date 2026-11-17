package com.soa.klef.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import com.soa.klef.entity.Tourist;
import com.soa.klef.service.TouristService;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {

    private final TouristService service;
    private static final String VALID_TOKEN = "my-secret-token-123";

    public TouristController(TouristService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
        summary = "Fetch all tourists",
        parameters = {
            @Parameter(
                name = "token",
                in = ParameterIn.HEADER,
                required = false,
                description = "Existing pre-generated token: my-secret-token-123"
            )
        }
    )
    public ResponseEntity<?> getAllTourists(
            @RequestHeader(value = "token", required = false) String token) {

        if (!isValidToken(token)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Invalid or Missing Token");
        }

        return ResponseEntity.ok(service.getAllTourists());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Fetch a tourist by ID",
        parameters = {
            @Parameter(
                name = "token",
                in = ParameterIn.HEADER,
                required = false,
                description = "Existing pre-generated token: my-secret-token-123"
            )
        }
    )
    public ResponseEntity<?> getTouristById(
            @PathVariable Long id,
            @RequestHeader(value = "token", required = false) String token) {

        if (!isValidToken(token)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Invalid or Missing Token");
        }

        Optional<Tourist> tourist = service.getTouristById(id);

        if (tourist.isPresent()) {
            return ResponseEntity.ok(tourist.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tourist not found with ID: " + id);
    }

    private boolean isValidToken(String token) {
        return token != null && VALID_TOKEN.equals(token);
    }
}
