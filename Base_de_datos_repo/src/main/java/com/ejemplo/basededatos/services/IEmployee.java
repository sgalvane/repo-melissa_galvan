package com.ejemplo.basededatos.services;

import org.springframework.http.ResponseEntity;

public interface IEmployee {

    ResponseEntity getEmployees();

    ResponseEntity getEmployeeId(Long id);

    ResponseEntity getEmployeeAge();

    ResponseEntity getEmployeeSalary();
}
