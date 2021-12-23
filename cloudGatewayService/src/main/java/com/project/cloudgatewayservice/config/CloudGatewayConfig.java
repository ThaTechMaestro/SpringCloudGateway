package com.project.cloudgatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;




@Configuration
public class CloudGatewayConfig {


    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){

        return builder.routes()
                .route(r -> r.path("/employee/**")
                        .uri("http://localhost:8082"))

                .route(r -> r.path("/consumer/**")
                        .uri("http://localhost:8083"))

                .route(r -> r.path("/google/**")
                        .uri("https://www.google.com"))

                .build();





    }



}
