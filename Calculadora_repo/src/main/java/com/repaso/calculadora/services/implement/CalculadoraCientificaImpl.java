package com.repaso.calculadora.services.implement;

import com.repaso.calculadora.config.CalculadoraCientificaConfig;
import com.repaso.calculadora.services.ICalculadora;
import com.repaso.calculadora.services.ICalculadoraCientifica;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraCientificaImpl implements ICalculadoraCientifica {

    CalculadoraCientificaConfig calculadoraCientificaConfig;

    public CalculadoraCientificaImpl(CalculadoraCientificaConfig calculadoraCientificaConfig) {
        this.calculadoraCientificaConfig = calculadoraCientificaConfig;
    }

    public ResponseEntity getRaiz(String valor){

        double num = Double.parseDouble(valor);
        double resultado = Math.sqrt(num);
        return ResponseEntity.ok(resultado);
    }

    public ResponseEntity getSeno(String valor) {

        double num = Double.parseDouble(valor);
        double result = Math.sin(num);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity getCoseno(String valor){

        double num = Double.parseDouble(valor);
        double result = Math.cos(num);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity getArea(String valor){

        double radio = Double.parseDouble(valor);
        double area = Math.PI * Math.pow(radio, 2);
        return ResponseEntity.ok(area);
    }
    public ResponseEntity getPerimetro(String valor){

        double radio = Double.parseDouble(valor);
        double perimetro = 2 * Math.PI * radio;
        return ResponseEntity.ok(perimetro);
    }


    public ResponseEntity getTriangulo(String base, String altura){

        double valor1 = Double.parseDouble(base);
        double valor2 = Double.parseDouble(altura);
        double area = (valor1*valor2)/2;
        return ResponseEntity.ok(area);
    }
}
