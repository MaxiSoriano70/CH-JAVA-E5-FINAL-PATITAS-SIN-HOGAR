package com.patitas.sin.hogar.patitasSinHogar.security.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SegurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth ->
                {
                    // Endpoints sin autenticación
                    auth.requestMatchers("/auth/**").permitAll();

                    // Endpoints accesibles solo para ADMIN
                    auth.requestMatchers(HttpMethod.GET, "/usuario/**").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.POST, "/usuario/**").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.DELETE, "/usuario/**").hasRole("ADMIN");

                    // Endpoints accesibles para ADMIN y USER
                    auth.requestMatchers(HttpMethod.GET, "/usuario/{id}").hasAnyRole("ADMIN", "USER");
                    auth.requestMatchers(HttpMethod.PUT, "/usuario/{id}").hasAnyRole("ADMIN", "USER");

                    // Endpoints de mascotas
                    auth.requestMatchers(HttpMethod.GET, "/mascota").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/mascota/{id}").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/mascota/**").hasAnyRole("ADMIN", "USER");
                    auth.requestMatchers(HttpMethod.PUT, "/mascota/{id}").hasAnyRole("ADMIN", "USER");
                    auth.requestMatchers(HttpMethod.DELETE, "/mascota/{id}").hasAnyRole("ADMIN", "USER");

                    // Endpoints de adopciones
                    auth.requestMatchers(HttpMethod.GET, "/adopcion").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/adopcion/{id}").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/adopcion/**").hasAnyRole("ADMIN", "USER");
                    auth.requestMatchers(HttpMethod.PUT, "/adopcion/{id}").hasAnyRole("ADMIN", "USER");
                    auth.requestMatchers(HttpMethod.DELETE, "/adopcion/{id}").hasAnyRole("ADMIN", "USER");

                    //
                    auth.requestMatchers("/api/users/**").permitAll();
                    auth.requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/webjars/**").permitAll();


                    auth.anyRequest().authenticated();
                })
                .csrf(config -> config.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider)
                .build();
    }
}
