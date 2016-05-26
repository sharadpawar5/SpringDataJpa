package com.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner{
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Employee[] employees={
				new Employee(123,"Johney Depp","Film Star"),
				new Employee(124,"Sachin","Cricketer"),
				new Employee(125,"Anand","Chess")
		};
		for (Employee employee : employees) {
			employeeRepository.save(employee);
		}
		
		List<Employee> listOfEmployees = employeeRepository.findAll();
		
		for (Employee employee : listOfEmployees) {
			System.out.println("Employee :"+employee.toString());
			
		}
	}
}
