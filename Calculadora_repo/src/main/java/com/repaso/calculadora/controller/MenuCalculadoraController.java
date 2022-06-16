package com.repaso.calculadora.controller;

import com.repaso.calculadora.services.IMenuCalculadora;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calculadora")
public class MenuCalculadoraController {

    IMenuCalculadora iMenuCalculadora;

    public MenuCalculadoraController(IMenuCalculadora iMenuCalculadora) {
        this.iMenuCalculadora = iMenuCalculadora;
    }

    @GetMapping("/menu")
    public ResponseEntity getMenu(){
        return iMenuCalculadora.getMenu();
    }
}
