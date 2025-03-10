package com.patitas.sin.hogar.patitasSinHogar.apiexterna.controller;

import com.patitas.sin.hogar.patitasSinHogar.apiexterna.entity.ApiResponse;
import com.patitas.sin.hogar.patitasSinHogar.apiexterna.service.DataRestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class DataRestApiController {
    @Autowired
    private DataRestApiService dataRestApiService;
    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAll() {
        return ResponseEntity.ok().body(new ApiResponse("OK", dataRestApiService.getUsers(), ""));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(new ApiResponse("OK", dataRestApiService.getUserById(id), ""));
    }

    @GetMapping("/registerById/{id}")
    public ResponseEntity<ApiResponse> registerById(@PathVariable String id) {
        return ResponseEntity.ok().body(new ApiResponse("OK", dataRestApiService.registerApiById(id), ""));
    }
}
