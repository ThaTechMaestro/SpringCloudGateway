package com.project.cloudgatewayservice.config;

import com.project.cloudgatewayservice.test.UriConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;




@Configuration
@EnableConfigurationProperties(UriConfiguration.class)
public class CloudGatewayConfig {


    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration){
        String httpUri = uriConfiguration.getHttpbin();

        return builder.routes()
                .route(r -> r.path("/employee/**")
                        .uri("http://firstms:8082"))

                .route(r -> r.path("/consumer/**")
                        .uri("http://secondms:8083"))

                .route(r -> r.path("/")
                        .uri("https://www.google.com"))

                .route(r -> r
                        .host("*.circuitbreaker.com")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("mycmd")
                                .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))

                .build();





    }



}
