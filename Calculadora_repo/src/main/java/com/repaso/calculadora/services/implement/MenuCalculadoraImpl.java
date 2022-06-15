package com.repaso.calculadora.services.implement;

import com.repaso.calculadora.config.CalculadoraCientificaConfig;
import com.repaso.calculadora.config.CalculadoraConfig;
import com.repaso.calculadora.services.IMenuCalculadora;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MenuCalculadoraImpl implements IMenuCalculadora {

    private final CalculadoraConfig calculadoraConfig;

    private final CalculadoraCientificaConfig calculadoraCientificaConfig;


    public MenuCalculadoraImpl(CalculadoraConfig calculadoraConfig, CalculadoraCientificaConfig calculadoraCientificaConfig) {
        this.calculadoraConfig = calculadoraConfig;
        this.calculadoraCientificaConfig = calculadoraCientificaConfig;
    }

    public ResponseEntity getMenu(){

        String resultado = "" +

                "\n"+calculadoraConfig.getMensaje(CalculadoraConfig.SUMA)+
                "\n"+calculadoraConfig.getMensaje(CalculadoraConfig.RESTA)+
                "\n"+calculadoraConfig.getMensaje(CalculadoraConfig.MULTIPLICACION)+
                "\n"+calculadoraConfig.getMensaje(CalculadoraConfig.DIVISION)+
                "\n"+calculadoraCientificaConfig.getFunciones(CalculadoraCientificaConfig.RAIZ)+
                "\n"+calculadoraCientificaConfig.getFunciones(CalculadoraCientificaConfig.SENO)+
                "\n"+calculadoraCientificaConfig.getFunciones(CalculadoraCientificaConfig.COSENO)+
                "\n"+calculadoraCientificaConfig.getFunciones(CalculadoraCientificaConfig.AREA)+
                "\n"+calculadoraCientificaConfig.getFunciones(CalculadoraCientificaConfig.PERIMETRO)+
                "\n"+calculadoraCientificaConfig.getFunciones(CalculadoraCientificaConfig.TRIANGULO);

        return ResponseEntity.ok(resultado);
    }
}
