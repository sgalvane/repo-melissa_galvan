package com.repaso.calculadora.services.implement;
import com.repaso.calculadora.config.MenuConfig;
import com.repaso.calculadora.services.IMenuCalculadora;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MenuCalculadoraImpl implements IMenuCalculadora {

    private final MenuConfig menuConfig;

    public MenuCalculadoraImpl(MenuConfig menuConfig) {
        this.menuConfig = menuConfig;
    }

    public ResponseEntity getMenu(){

        String lista = "Menu de mi calculadora";
        ArrayList<String> menu = new ArrayList<>(menuConfig.getFuncion().values());
        for (String m:menu){
            lista += "\n" + m;
    } return ResponseEntity.ok(lista + "\n");
    }

}