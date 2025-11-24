package cl.iplacex.automatizacion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraServicioIT {

    @Test
    void flujoCompletoDeSumaDebeSerCorrecto() {
        CalculadoraServicio svc = new CalculadoraServicio();

        int parcial = svc.sumar(10, 15);              // 25
        int total = svc.sumarTres(parcial, 5, 10);    // 25 + 5 + 10 = 40

        Assertions.assertEquals(40, total, "El flujo completo de suma debe dar 40");
    }
}