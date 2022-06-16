package com.repaso.calculadora.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "calculadora")
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
