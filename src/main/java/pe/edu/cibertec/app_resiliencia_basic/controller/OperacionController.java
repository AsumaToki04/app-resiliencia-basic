package pe.edu.cibertec.app_resiliencia_basic.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.app_resiliencia_basic.service.OperacionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/operacion")
public class OperacionController {
    private final OperacionService operacionService;

    @GetMapping
    @CircuitBreaker(name = "myService", fallbackMethod = "fallBackMethod")
    public String metodoRemoto() {
        return operacionService.metodoRemoto();
    }

    public String fallBackMethod(Throwable throwable) {
        return "Servicio temporalmente no disponible. Intentalo de nuevo.";
    }
}
