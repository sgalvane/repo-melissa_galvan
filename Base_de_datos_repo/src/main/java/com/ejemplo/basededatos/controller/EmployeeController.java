package com.ejemplo.basededatos.controller;

import com.ejemplo.basededatos.controller.docs.EmployeeDocs;
import com.ejemplo.basededatos.services.IEmployee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController implements EmployeeDocs {


    private IEmployee iEmployee;

    public EmployeeController(IEmployee iEmployee) {
        this.iEmployee = iEmployee;
    }

    @Override
    @GetMapping("/employees-list")
    public ResponseEntity getEmployees() {
        return iEmployee.getEmployees();
    }

    @Override
    @GetMapping("/employees/{id}")
    public ResponseEntity getEmployeeId(Long id) {
        return iEmployee.getEmployeeId(id);
    }

    @Override
    @GetMapping("/employees-list/age")
    public ResponseEntity getEmployeeAge() {
        return iEmployee.getEmployeeAge();
    }

    @Override
    @GetMapping("/employees-list/salary")
    public ResponseEntity getEmployeeSalary() {
        return iEmployee.getEmployeeSalary();
    }

}
