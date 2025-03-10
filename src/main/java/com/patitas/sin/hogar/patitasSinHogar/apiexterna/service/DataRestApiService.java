package com.patitas.sin.hogar.patitasSinHogar.apiexterna.service;

import com.patitas.sin.hogar.patitasSinHogar.apiexterna.component.DataRestApiComponent;
import com.patitas.sin.hogar.patitasSinHogar.security.controller.AuthenticationController;
import com.patitas.sin.hogar.patitasSinHogar.security.dto.AuthenticationResponse;
import com.patitas.sin.hogar.patitasSinHogar.security.dto.RegisterRequest;
import com.patitas.sin.hogar.patitasSinHogar.security.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataRestApiService {
    @Autowired
    private DataRestApiComponent dataRestApiComponent;
    @Autowired
    private AuthenticationController authenticationController;
    public List<?> getUsers(){
        return dataRestApiComponent.getUsers();
    }

    public RegisterRequest getUserById(String id) {
        return dataRestApiComponent.getUserById(id);
    }

    public ResponseEntity<AuthenticationResponse> registerApiById(String id) {
        RegisterRequest usuarioARegistrar = dataRestApiComponent.registerApiForId(id);
        return authenticationController.register(usuarioARegistrar);
    }
}
