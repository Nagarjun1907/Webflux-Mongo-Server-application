/*
package com.springwebflux.demo.WebfluxMongoDemo.controller;

import com.springwebflux.demo.WebfluxMongoDemo.model.Employee;
import com.springwebflux.demo.WebfluxMongoDemo.model.EmployeeEvents;
import com.springwebflux.demo.WebfluxMongoDemo.repository.EmployeeRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/all")
    public Flux<Employee> getAllEmployees() {
            return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable("id") Integer empId){
        return  employeeRepository.findById(empId);
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EmployeeEvents> getEmployeesEvents(@PathVariable("id") Integer empId){
            return employeeRepository.findById(empId)
                    .flatMapMany(employee -> {
                        Flux<Long> intervalFlux = Flux.interval(Duration.ofSeconds(2));

                        Flux<EmployeeEvents> employeeEventsFlux =
                                    Flux.fromStream(Stream.generate(()-> new EmployeeEvents(employee, new Date())));

                        return Flux.zip(intervalFlux,employeeEventsFlux).map(objects -> objects.getT2());
                    });
    }
}
*/
