package com.example.spring.api.controller;

import com.example.spring.api.model.Employee;
import com.example.spring.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void addEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(893, "Nisha Tiwari", new String[] {"Montreal", "Canada"}));
        employeeList.add(new Employee(754, "Chinky Tiwari", new String[] {"San Franciso", "California"}));
        employeeList.add(new Employee(93, "Neha Shinde", new String[] {"London", "United Kingdom"}));
        employeeList.add(new Employee(193, "Aum D Shukla", new String[] {"Melbourne", "Australia"}));
        employeeList.add(new Employee(293, "Kaavya Duggal", new String[] {"Los Angeles", "California"}));
        employeeList.add(new Employee(493, "Dolly Tiwari", new String[] {"Los Angeles", "California"}));
        employeeRepository.saveAll(employeeList);
    }

    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{name}")
    public Employee getEmployee(@PathVariable String name) {
        return employeeRepository.findByName(name);
    }

    @GetMapping("/search/{searchTerm}")
    public Page<Employee> searchEmployee(@PathVariable String searchTerm) {
        return employeeRepository.findEmployeeByName(searchTerm, PageRequest.of(0, 3));
    }
}
