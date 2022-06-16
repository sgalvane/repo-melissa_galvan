package com.repaso.calculadora.controller;

import com.repaso.calculadora.services.ICalculadora;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    private final ICalculadora iCalculadora;

    public CalculadoraController(ICalculadora iCalculadora) {
        this.iCalculadora = iCalculadora;
    }

    @GetMapping("/suma")
    public ResponseEntity getSuma(@PathParam("numero1")String numero1, @PathParam("numero2")String numero2){
        return iCalculadora.getSuma(numero1, numero2);
    }

    @GetMapping("/resta")
    public ResponseEntity getResta(@PathParam("numero1")String numero1, @PathParam("numero2")String numero2){
        return iCalculadora.getResta(numero1, numero2);
    }

    @GetMapping("/multiplicacion")
    public ResponseEntity getMultiplicacion(@PathParam("numero1")String numero1, @PathParam("numero2")String numero2){
        return iCalculadora.getMultiplicacion(numero1, numero2);
    }

    @GetMapping("/division")
    public ResponseEntity getDivision(@PathParam("numero1")String numero1, @PathParam("numero2")String numero2){
        return iCalculadora.getDivision(numero1, numero2);
    }
}
