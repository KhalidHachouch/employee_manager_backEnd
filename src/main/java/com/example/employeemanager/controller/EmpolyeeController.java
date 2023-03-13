package com.example.employeemanager.controller;

import com.example.employeemanager.entities.Employee;
import com.example.employeemanager.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class EmpolyeeController {
    private final EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employees=employeeService.allEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/emplpyee/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable long id){
        Employee employee=employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> add(@RequestBody Employee employee){
        Employee newEmployee =employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        Employee updateEmployees=employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployees, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
