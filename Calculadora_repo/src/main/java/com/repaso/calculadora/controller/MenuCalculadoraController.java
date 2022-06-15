package com.repaso.calculadora.controller;

import com.repaso.calculadora.services.IMenuCalculadora;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calculadora")
@RestController
public class MenuCalculadoraController {

    IMenuCalculadora intMenuCalculadora;

    @GetMapping("/menu")

    public ResponseEntity getMenu(){
        return intMenuCalculadora.getMenu();
    }
}
