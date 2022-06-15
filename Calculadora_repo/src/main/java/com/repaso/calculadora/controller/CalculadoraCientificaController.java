package com.repaso.calculadora.controller;

import com.repaso.calculadora.services.ICalculadoraCientifica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RequestMapping("/calculadora")
@RestController
public class CalculadoraCientificaController {

   ICalculadoraCientifica iCalculadoraCientifica;

    @GetMapping("/raiz")

    public ResponseEntity getRaiz(@PathParam("valor")String valor){
        return iCalculadoraCientifica.getRaiz(valor);

    }

    @GetMapping("/seno")

    public ResponseEntity getSeno(@PathParam("valor")String valor) {
        return iCalculadoraCientifica.getSeno(valor);

    }

    @GetMapping("/coseno")

    public ResponseEntity getCoseno(@PathParam("valor")String valor){
        return iCalculadoraCientifica.getCoseno(valor);
    }

    @GetMapping("/circulo")

    public ResponseEntity getArea(@PathParam("valor")String valor){
        return iCalculadoraCientifica.getArea(valor);

    }

    @GetMapping("/perimetro")

    public ResponseEntity getPerimetro(@PathParam("valor")String valor){
        return iCalculadoraCientifica.getPerimetro(valor);
    }

    @GetMapping("/triangulo")

    public ResponseEntity getTriangulo(@PathParam("")String base, @PathParam("")String altura){
        return iCalculadoraCientifica.getTriangulo(base, altura);
    }

}
