package com.springwebflux.demo.WebfluxMongoDemo.repository;

import com.springwebflux.demo.WebfluxMongoDemo.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer> {
}
