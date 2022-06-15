package com.repaso.calculadora.services;
import org.springframework.http.ResponseEntity;

public interface ISaludo {

    ResponseEntity saludoDia (String dia);

    ResponseEntity saludoMediodia (String mediodia);

    ResponseEntity saludoNoche (String noche);
}
