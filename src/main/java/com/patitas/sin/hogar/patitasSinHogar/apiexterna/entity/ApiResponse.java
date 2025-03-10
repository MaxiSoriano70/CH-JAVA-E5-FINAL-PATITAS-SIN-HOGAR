package com.patitas.sin.hogar.patitasSinHogar.apiexterna.entity;

import lombok.Data;

@Data
public class ApiResponse {
    private String msg;
    private Object data;
    private String error;

    public ApiResponse() {
    }

    public ApiResponse(String msg, Object data, String error) {
        this.msg = msg;
        this.data = data;
        this.error = error;
    }
}
