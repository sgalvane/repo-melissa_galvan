package com.repaso.calculadora.services.implement;
import com.repaso.calculadora.config.CalculadoraConfig;
import com.repaso.calculadora.services.ICalculadora;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraImpl implements ICalculadora {

    CalculadoraConfig calculadoraConfig;

    public CalculadoraImpl(CalculadoraConfig calculadoraConfig) {
        this.calculadoraConfig = calculadoraConfig;
    }

    @Value("${calculadora.mensaje.suma}")
    String mensajeSuma;

    @Value("${calculadora.mensaje.resta}")
    String mensajeResta;

    @Value("${calculadora.mensaje.multiplicacion}")
    String mensajeMultiplicacion;

    @Value("${calculadora.mensaje.division}")
    String mensajeDivision;


    public ResponseEntity getSuma(String numero1, String numero2){
        int num1 = Integer.parseInt(numero1);
        int num2 = Integer.parseInt(numero2);
        int resultado= num1 + num2;
        return ResponseEntity.ok(resultado +" "+ mensajeSuma);
    }

    public ResponseEntity getResta(String numero1, String numero2){
        int num1 = Integer.parseInt(numero1);
        int num2 = Integer.parseInt(numero2);
        int resultado = num1 - num2;
        return ResponseEntity.ok(resultado + " " + mensajeResta);
    }

    public ResponseEntity getMultiplicacion(String numero1, String numero2){
        int num1 = Integer.parseInt(numero1);
        int num2 = Integer.parseInt(numero2);
        int resultado = num1 * num2;
        return ResponseEntity.ok(resultado + " " + mensajeMultiplicacion);
    }


    public ResponseEntity getDivision(String numero1, String numero2){
        double num1 = Double.parseDouble(numero1);
        double num2 = Double.parseDouble(numero2);
        double resultado = num1 / num2;
        return ResponseEntity.ok(resultado + " " + mensajeDivision);
    }
}
