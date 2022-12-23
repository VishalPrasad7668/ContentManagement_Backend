package com.niit.spring_cloud_api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(predicate1 -> predicate1
                        .path("/content/**")
                        .uri("http://localhost:8095"))
                .route(predicate2 -> predicate2
                        .path("/userservice/**")
                        .uri("http://localhost:8089"))
                .build();
    }
}
