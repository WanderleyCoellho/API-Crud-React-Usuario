package com.projeto;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") //Permite CORS para todas as URLs que começam com /api/
            .allowedOrigins("http://localhost:5173") //Permite requisições DESTE endereço
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //Permite estes métodos
            .allowedHeaders("*") //Permite todos os cabeçalhos
            .allowCredentials(true);
    }
}