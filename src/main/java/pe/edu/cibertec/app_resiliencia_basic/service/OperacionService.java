package pe.edu.cibertec.app_resiliencia_basic.service;

import org.springframework.stereotype.Service;

@Service
public class OperacionService {

    public String metodoRemoto() {
        if(Math.random() > 0.5) {
            throw new RuntimeException("Error en la llamada.");
        }
        return "Respuesta exitosa del servicio remoto.";
    }
}
