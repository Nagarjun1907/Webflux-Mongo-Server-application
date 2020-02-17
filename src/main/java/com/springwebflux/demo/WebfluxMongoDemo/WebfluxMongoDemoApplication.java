package com.springwebflux.demo.WebfluxMongoDemo;

import com.springwebflux.demo.WebfluxMongoDemo.model.Employee;
import com.springwebflux.demo.WebfluxMongoDemo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class WebfluxMongoDemoApplication {

	@Bean
	CommandLineRunner saveEmployees(EmployeeRepository employeeRepository){
		return args -> {
			employeeRepository.deleteAll()
							  .subscribe(null,null,() ->{
									Stream.of(new Employee(100, "Sachin" , 20000L),
											new Employee(101, "Ganguly" , 30000L),
											new Employee(102, "Sehwag" , 40000L),
											new Employee(103, "Dravid" , 50000L)
											).forEach(employee -> {
												employeeRepository.save(employee)
																.subscribe(System.out::println);
									});
							  });
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(WebfluxMongoDemoApplication.class, args);
	}

}
