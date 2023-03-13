package com.example.employeemanager.service;

import com.example.employeemanager.entities.Employee;
import com.example.employeemanager.exception.UserNotFoundException;
import com.example.employeemanager.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> allEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(long id){
        employeeRepository.deleteById(id);
    }

    public Employee findEmployeeById(long id){
        return employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Employee by id" + id + " not found"));
    }
}
