package com.patitas.sin.hogar.patitasSinHogar.apiexterna.component;

import com.patitas.sin.hogar.patitasSinHogar.security.dto.RegisterRequest;
import com.patitas.sin.hogar.patitasSinHogar.security.entity.Usuario;
import com.patitas.sin.hogar.patitasSinHogar.utils.ERol;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class DataRestApiComponent {
    public final String URL_PLACE_HOLDER = "https://jsonplaceholder.typicode.com/";

    public List<?> getUsers() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URL_PLACE_HOLDER + "users", List.class);
    }
    public RegisterRequest getUserById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = URL_PLACE_HOLDER + "users/{id}";
        System.out.println(url);

        Map<String, Object> response = restTemplate.getForObject(url, Map.class, id);
        if (response == null) {
            return null;
        }

        String nombre = (String) response.get("name");
        String apellido = (String) response.get("username");
        String email = (String) response.get("email");
        String telefono = (String) response.get("phone");


        return RegisterRequest.builder()
                .nombre(nombre)
                .apellido(apellido)
                .email(email)
                .password("1234")
                .telefono(telefono)
                .role(ERol.USER)
                .build();
    }

    public RegisterRequest registerApiForId(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = URL_PLACE_HOLDER + "users/{id}";
        System.out.println(url);

        Map<String, Object> response = restTemplate.getForObject(url, Map.class, id);
        if (response == null) {
            return null;
        }

        String nombre = (String) response.get("name");
        String apellido = (String) response.get("username");
        String email = (String) response.get("email");
        String telefono = (String) response.get("phone");


        return RegisterRequest.builder()
                .nombre(nombre)
                .apellido(apellido)
                .email(email)
                .password("1234")
                .telefono(telefono)
                .role(ERol.USER)
                .build();
    }
}
