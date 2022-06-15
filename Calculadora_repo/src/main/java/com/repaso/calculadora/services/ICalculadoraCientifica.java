package com.repaso.calculadora.services;
import org.springframework.http.ResponseEntity;

public interface ICalculadoraCientifica {

    ResponseEntity getRaiz(String valor);

    ResponseEntity getSeno(String valor);

    ResponseEntity getCoseno(String valor);

    ResponseEntity getArea(String valor);

    ResponseEntity getPerimetro(String valor);

    ResponseEntity getTriangulo(String base, String altura);
}
