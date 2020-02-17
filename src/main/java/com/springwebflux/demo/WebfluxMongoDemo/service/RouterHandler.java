package com.springwebflux.demo.WebfluxMongoDemo.service;

import com.springwebflux.demo.WebfluxMongoDemo.model.Employee;
import com.springwebflux.demo.WebfluxMongoDemo.model.EmployeeEvents;
import com.springwebflux.demo.WebfluxMongoDemo.repository.EmployeeRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@Component
public class RouterHandler {

    private EmployeeRepository employeeRepository;

    public RouterHandler(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Mono<ServerResponse> getAllEmployees(ServerRequest serverRequest) {
       return ServerResponse.ok().body(employeeRepository.findAll(), Employee.class);
    }

    public Mono<ServerResponse> getEmployeeById(ServerRequest serverRequest) {
        Integer empId = Integer.valueOf(serverRequest.pathVariable("id"));
        return  ServerResponse.ok().body(
                employeeRepository.findById(empId), Employee.class
        );
    }

    public Mono<ServerResponse> getEmployeeByEvents(ServerRequest serverRequest) {
        Integer empId = Integer.valueOf(serverRequest.pathVariable("id"));
        return  ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(
             employeeRepository.findById(empId)
                .flatMapMany(employee -> {
                    Flux<Long> intervalFlux = Flux.interval(Duration.ofSeconds(2));

                    Flux<EmployeeEvents> employeeEventsFlux =
                            Flux.fromStream(Stream.generate(()-> new EmployeeEvents(employee, new Date())));

                    return Flux.zip(intervalFlux,employeeEventsFlux).map(objects -> objects.getT2());
                }), EmployeeEvents.class
        );
    }
}