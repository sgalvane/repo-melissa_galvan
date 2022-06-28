package com.ejemplo.basededatos.providers;

import com.ejemplo.basededatos.dto.api.dummy.ResponseBodyDTO;
import com.ejemplo.basededatos.dto.api.dummy.ResponseIdDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "apiexample",
        url = "${restapiexample.url}"
)
public interface EmployeesFeingProvider {

    @GetMapping("/employees")
    ResponseBodyDTO getListEmployee();

    @GetMapping("/employee/{id}")
    ResponseIdDTO getIdEmployees(@PathVariable Long id);

}
