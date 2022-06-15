package com.repaso.calculadora.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraConfig {

    public static final String SUMA = "suma";

    public static final String RESTA = "resta";

    public static final String MULTIPLICACION = "multiplicacion";

    public static final String DIVISION = "division";


    private Map<String, String> mensaje;

    public String getMensaje(String list) {
        return mensaje.get(list);
    }

    public Map<String, String> getMensaje() {
        return mensaje;
    }

    public void setMensaje(Map<String, String> mensaje) {
        this.mensaje = mensaje;
    }
}
