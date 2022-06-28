package com.ejemplo.basededatos.services.impl;

import com.ejemplo.basededatos.dto.api.dummy.ResponseBodyDTO;
import com.ejemplo.basededatos.dto.api.dummy.ResponseEmployeesDTO;
import com.ejemplo.basededatos.dto.api.dummy.ResponseIdDTO;
import com.ejemplo.basededatos.providers.EmployeesFeingProvider;
import com.ejemplo.basededatos.services.IEmployee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeImpl implements IEmployee{

    private final EmployeesFeingProvider employeesFeingProvider;

    public EmployeeImpl(EmployeesFeingProvider employeesFeingProvider) {
        this.employeesFeingProvider = employeesFeingProvider;
    }

    @Override
    public ResponseEntity getEmployees() {
        ResponseBodyDTO responseBodyDTO;
        ResponseEntity responseEntity;

        try {
            responseBodyDTO = employeesFeingProvider.getListEmployee();
            responseEntity = ResponseEntity.ok(responseBodyDTO);
        } catch (Exception e) {
            responseEntity = ResponseEntity.ok(e.getCause());
        }
        return responseEntity;
    }


    @Override
    public ResponseEntity getEmployeeId(Long id) {
        ResponseIdDTO responseIdDTO;
        ResponseEntity response;

        try {
            responseIdDTO = employeesFeingProvider.getIdEmployees(id);
            response = ResponseEntity.ok(responseIdDTO);
        } catch (Exception e){
            response = ResponseEntity.ok(e.getCause());
        }
        return response;
    }

    @Override
    public ResponseEntity getEmployeeAge() {
        ResponseBodyDTO responseBodyDTO;
        ResponseEntity response;

        try {
            responseBodyDTO = employeesFeingProvider.getListEmployee();
            List<ResponseEmployeesDTO> employeeList = responseBodyDTO.getData();
            List<ResponseEmployeesDTO> ageList = new ArrayList<>();

            for (ResponseEmployeesDTO a:employeeList) {
                if (a.getEmployeeAge() > 30) {
                    ageList.add(a);
                }
            }
                response = ResponseEntity.ok(ageList);
            }catch(Exception e){
                response = ResponseEntity.ok(e.getCause());
            }
            return response;
        }

    @Override
    public ResponseEntity getEmployeeSalary() {
        ResponseBodyDTO responseBodyDTO;
        ResponseEntity response;

        try {
            responseBodyDTO = employeesFeingProvider.getListEmployee();
            List<ResponseEmployeesDTO> employeeList = responseBodyDTO.getData();
            List<ResponseEmployeesDTO> salaryList = new ArrayList<>();

            for (ResponseEmployeesDTO a:employeeList) {
                if (a.getEmployeeSalary() > 100000) {
                    salaryList.add(a);
                }
            }
            response = ResponseEntity.ok(salaryList);
        }catch(Exception e){
            response = ResponseEntity.ok(e.getCause());
        }
        return response;
    }

}
