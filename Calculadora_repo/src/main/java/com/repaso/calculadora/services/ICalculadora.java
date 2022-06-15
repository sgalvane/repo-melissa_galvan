package com.repaso.calculadora.services;
import org.springframework.http.ResponseEntity;

public interface ICalculadora {

    ResponseEntity getSuma(String numero1, String numero2);

    ResponseEntity getResta(String numero1, String numero2);

    ResponseEntity getMultiplicacion(String numero1, String numero2);

    ResponseEntity getDivision(String numero1, String numero2);
}
