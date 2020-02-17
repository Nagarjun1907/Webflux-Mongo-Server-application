package com.springwebflux.demo.WebfluxMongoDemo.config;

import com.springwebflux.demo.WebfluxMongoDemo.service.RouterHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class ReactiveConfig {

    @Bean
    RouterFunction routerFunction(RouterHandler routerHandler){
        return RouterFunctions.route(RequestPredicates.GET("/rest/employee/all"), routerHandler::getAllEmployees)
                .andRoute(RequestPredicates.GET("/rest/employee/{id}"), routerHandler::getEmployeeById)
                .andRoute(RequestPredicates.GET("/rest/employee/{id}/events"), routerHandler::getEmployeeByEvents);

    }
}
