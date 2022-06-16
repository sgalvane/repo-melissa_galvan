package com.repaso.calculadora.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "menu")
public class MenuConfig {

    public static final String SUMA="suma";

    public static final String RESTA="resta";

    public static final String MULTIPLICACION="multiplicacion";

    public static final String DIVISION="division";

    public static final String RAIZ="raiz";

    public static final String SENO="seno";

    public static final String COSENO="coseno";

    public static final String AREA="area";

    public static final String PERIMETRO="perimetro";

    public static final String TRIANGULO="triangulo";

    private Map<String, String> funcion;

    public String getFunciones(String list){
        return funcion.get(list);
    }

    public Map<String, String> getFuncion() {
        return funcion;
    }

    public void setFuncion(Map<String, String> funcion) {
        this.funcion = funcion;
    }

}
