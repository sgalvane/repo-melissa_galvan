package com.repaso.calculadora.controller;

import com.repaso.calculadora.services.ISaludo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/saludo")
public class SaludoController {

    private final ISaludo iSaludo;

    public SaludoController(ISaludo iSaludo) {
        this.iSaludo = iSaludo;
    }

    @GetMapping("/saludoDia")
    public ResponseEntity getSaludoDia(@PathParam("dia")String dia){
        return iSaludo.saludoDia(dia);
    }

    @GetMapping("/saludoTarde")
    public ResponseEntity getSaludoMedio(@PathParam("mediodia")String mediodia){
        return iSaludo.saludoMediodia(mediodia);
    }

    @GetMapping("/saludoNoche")
    public ResponseEntity getSaludoNoche(@PathParam("noche")String noche){
        return iSaludo.saludoNoche(noche);
    }
}
